package online.shixun.project.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import online.shixun.project.pojo.Evaluate;
import online.shixun.project.service.EvaluateService;

@Controller
public class EvaluateTController {

	@Autowired
	EvaluateService evaluateService;
	/**
	 * 进入评教的主页面
	 * @return
	 */
	@RequestMapping("reviewshow")
	public String evaluateT() {
			
		return "review/reviewshow";
	}
	/**
	 * 评教页面
	 * @param fraction
	 * @param session 保存评教数据
	 * @param model
	 * @param id
	 * @param EvaluateId
	 * @return
	 */
	@RequestMapping("Instructor")
	public String Instructorindex(Integer fraction,HttpSession session,Model model,@RequestParam(defaultValue = "1") int id,@RequestParam(defaultValue = "1") int EvaluateId) {
		//查询所有的数据，这里主要编写分页而获取的数据
		List<Evaluate> eval = evaluateService.gatallEvaluateT(id,EvaluateId);
		//查询所有数据
		List<Evaluate> evalu = evaluateService.gatEvaluateById();
		//往前端页面传值
		model.addAttribute("evalu", evalu);
		model.addAttribute("Id", id);
		model.addAttribute("EvaluateId", EvaluateId);
		model.addAttribute("eval", eval);
		//新建一个常量
		Integer Tps=0;
		//新建一个集合，用来保存session对象
		List<Integer> Tpractiseids = (List<Integer>) session.getAttribute("Tpractiseids");
		if(Tpractiseids == null) {
			//如果为空就new一个新的
			Tpractiseids=new ArrayList<Integer>();
		}
		else  {
			//往集合里添加数据
			Tpractiseids.add(fraction);
		}
		//不管有没有数据都往集合里添加
		session.setAttribute("Tpractiseids", Tpractiseids);
	
			for(Integer attrids : Tpractiseids) {
				System.out.println(attrids);
				if(attrids==null) {
					attrids=0;
				}
					int tps =evaluateService.getpractiseidsById(attrids);
					Tps = Tps+tps;
					//把已经评教的数据添加到数据库
		}
			if(id==3&&Tps!=0) {
				session.invalidate();
			}
		model.addAttribute("Tps", Tps);
		return "review/Instructorshow";
	}

}