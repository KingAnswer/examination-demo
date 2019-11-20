package online.shixun.project.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.project.pojo.Answer;
import online.shixun.project.pojo.PaperPojo;
import online.shixun.project.pojo.Subject;
import online.shixun.project.pojo.UserPojo;
import online.shixun.project.pojo.javaOptions;
import online.shixun.project.pojo.javapractise;
import online.shixun.project.service.AnswerService;
import online.shixun.project.service.JavapractiseService;
import online.shixun.project.service.MakeService;
import online.shixun.project.service.OptionsService;
import online.shixun.project.service.PaperService;
import online.shixun.project.service.SubjectService;
import online.shixun.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	PaperService paperService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	AnswerService answerService;
	@Autowired
	JavapractiseService javapractiseService;
	@Autowired
	OptionsService optionsService;
	@Autowired
	MakeService makeService;
	//案例入口
	@RequestMapping(value="/system")
	public String entry() {
		//进入登录页面
		return "entry";
	}
	/**
	 * 考试系统主页
	 * @param model
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/doentry")
	public String index(Model model,String name,String password) {
		//获取登录名和密码
		UserPojo student = userService.getUserById(name,password);
		//查询paper表 id和name
		List<PaperPojo> paper = paperService.getAllpaper();
		//查询paper_inquiry id 和name
		List<PaperPojo> paperInquiry = paperService.getAllpaperInquiry();
		//查询paper_practise id和name
		List<PaperPojo> paperPractise = paperService.getAllpaperPractise();
		//查询paper id和name
		List<PaperPojo> paperRank = paperService.getAllpaperRank();
		//判断学生是否登录成功
		if(student!=null && "admin".equals(name)&&"123456".equals(password)) {
			model.addAttribute("student", student);
			model.addAttribute("paper", paper);
			model.addAttribute("paperInquiry", paperInquiry);
			model.addAttribute("paperPractise", paperPractise);
			model.addAttribute("paperRank", paperRank);
			//把获取的数据往前端index页面传送
			return "index";
			//判断教师是否登录成功
		}else if(student!=null && "teacher".equals(name)&&"123456".equals(password)) {
			model.addAttribute("teacher", student);
			//如果登录成功就跳转到teachers页面
			return "forward:/teachers";
		}else {
			//如果账号、密码
			return "entry";
		}
			
	}
	@RequestMapping("polvalue")
	public String polvalue(Model model,String id) {
		Cookie idCookie = new Cookie("id",id);
		return "practice/practiseJava";
	}
	/**
	 * 在线考试
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String detail(int id,Model model) {
		//如果id==1就是选中java开发测试题库
		if(id==1) {
			model.addAttribute("id", id);
			return "introduce/java";
		//id==2 前端开发测试题库
		}else if(id==2) {
			return "introduce/foreEnd";
		//id==3 软件测试开发题库
		}else
			return "introduce/test";
	}
	/**
	 * 开始java题库考试
	 * @param model
	 * @param id
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value="beginTest")
	public String beginTest(Model model,int id ,@RequestParam(defaultValue = "1")int subjectId) {
		//查询所有考试题目
		List<Subject> subject = subjectService.getallAnswer(id,subjectId);
		//查询所有试题编号（id）
		List<Subject> sub = subjectService.getsubjectById();
		model.addAttribute("sub", sub);
		model.addAttribute("subject", subject);
		model.addAttribute("subjectId", subjectId);
		model.addAttribute("id", id);
		//进入考试页面
		return "begin";
		}

	  @RequestMapping("/succer")
	  @ResponseBody
	  public int deld(String[] data,Model model,@RequestParam(defaultValue = "1")int answer_id) {
	    StringBuffer sb=new StringBuffer();
         for (int i=0; i<data.length; i++) {
                  if (!"".equals(data[i])) {
                      sb.append(data[i]);
                  if (i != data.length - 1) {
                       sb.append(";");
                   }
                    }       
              }
	              //用String的split方法分割，得到数组
	              data = sb.toString().split(";");
	               int s=0;
	    for (String integer : data) {
	        int istrue=optionsService.getbyid(integer);
	        s=s+istrue;
	    }  
	     System.out.println(s);
	     makeService.input(s,answer_id);//添加到score表中
	      return s;
	  }
	/**
	 * 完成考试，显示成绩页面
	 * @param model
	 * @param radioId
	 * @param hiddenId
	 * @return
	 */
	@RequestMapping("bandId")
	public String bandid(Model model,Integer radioId,Integer hiddenId) {
		List<Answer> an =answerService.gatradio(hiddenId);
		if(an!=null&&radioId==1) {
			model.addAttribute("an", an);
			System.out.println("回答正确");
			return "band";
		}else
			System.out.println("回答错误");
		return "introduce/test";
	}
	/**
	 * 分页答题页面
	 * @param session
	 * @param model
	 * @param practises
	 * @param id
	 * @param name
	 * @param practiseNo
	 * @return
	 */
	@RequestMapping("practise")
	public String practise(HttpSession session,Model model,Integer	practises,int id,String name,@RequestParam(defaultValue = "1")int practiseNo) {
		//新建一个常量，用来存放分数
		int option=0;
		//查询数据库所有的数据，并保存在集合里，完成分页功能
		List<javapractise> javaprac = javapractiseService.getallpractise(id,practiseNo);
		//查询题目所有数据
		List<PaperPojo> practise = paperService.getpractise(id,name);
		//新建一个集合，用来存放session前端获取保存的数据
		List<Integer> ids = (List<Integer>) session.getAttribute("ids");
		if(ids!=null && id==1) {
			//清除上一次答题session里所有数据
			session.invalidate();
		}
		if(ids == null) {
			//如果取出来的值为空，就new一个放进去
			ids=new ArrayList<Integer>();
		}
		else  {
			//如果session有数据就直接往集合里加数据
			ids.add(practises);
		}
		//这里表示我已经学好了所有数据
		if(id==6) {
			//新建一个对象，删选重复的数据
			HashSet attrid = new HashSet(ids);
			//将里面的所有元素都释放了并且清空里面的属性
			ids.clear();
			//往attrid放入数据
			ids.addAll(attrid);
			//遍历ids
			for(Integer attrids : ids) {
				//查询并得到数据，这里主要是判断对错
				int Option = optionsService.getintrue(attrids);
				if(Option!=0) {
					//数据叠加
					option = option+Option;
				}
				System.out.println(attrids);	
			}
		}
		//不管有没有，都要放入session中，进行覆盖，以便下次取出
		session.setAttribute("ids", ids);
		//往前端页面传数据
		model.addAttribute("option", option);
		model.addAttribute("javaprac", javaprac);
		model.addAttribute("practiseNo", practiseNo);
		model.addAttribute("id", id);	
		model.addAttribute("practisejava", practise);
		return "practice/practiseJava";
	}
	/**
	 * 评教
	 */
	@RequestMapping("review")
	public String review() {
		//请求转发到编写评教页面的controller
		return "forward:/reviewshow";
	}
}