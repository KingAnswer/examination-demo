package online.shixun.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.shixun.project.pojo.javaOptions;
import online.shixun.project.pojo.javapractise;
import online.shixun.project.service.JavapractiseService;
import online.shixun.project.service.OptionsService;

@Controller
public class TeacherController {

	@Autowired
	JavapractiseService javapractiseService;
	@Autowired
	OptionsService optionsService;
	@RequestMapping("teachers")
	public String index2(Model model) {
		List<javapractise> Tpractise = javapractiseService.getallTpractise();
		model.addAttribute("Tpractise", Tpractise);
		return "teacher/index2";
	}
	@RequestMapping("Tpractise")
	public String operate(Model model,int id,String name) {
		
		return "";
	}
	@RequestMapping("teacher/Tone")
	public String Tone() {
		return "teacher/teacherone";
	}
	@RequestMapping("teacher/Tincreased")
	public String Tincreased() {
		return "teacher/increas";
	}
	@RequestMapping("teacher/Tincreas")
	public String TincreasTitle(String name) {
		javapractise jpe = new javapractise();
		jpe.setName(name);
		javapractiseService.addPractise(name);		
		return "redirect:/teachers";
	}
	@RequestMapping("teacher/TincreasOptions")
	public String TincreasOptions(String topic,int javapractise_id,int isture) {
		javaOptions Tjos = new javaOptions();
		Tjos.setTopic(topic);
		Tjos.setJavapractise_id(javapractise_id);
		Tjos.setIsture(isture);
		optionsService.addOptions(topic,javapractise_id,isture);
		return "redirect:/teachers";
	}
	@RequestMapping("teacher/Trevise")
	public String Trevise(Model model) {
		List<javapractise> jpe = javapractiseService.getall();
		model.addAttribute("jpe", jpe);
		return "teacher/Trevise";
	}
	@RequestMapping("Tmrevise")
	public String Tmrevise(Model model,int id) {
		List<javapractise> javarevise = javapractiseService.getallrevise(id);
		model.addAttribute("javarevise", javarevise);
		System.out.println(javarevise);
		return "teacher/TMrevise";
	}
	@RequestMapping("modify")
	public String Tincreasmodify(int rid,String topic,int javapractise_id,int isture,int id,String name) {
		javapractise Tios = new javapractise();
		Tios.setId(id);
		Tios.setName(name);
		javapractiseService.addjavamodify(id,name);
		javaOptions Tjos = new javaOptions();
		Tjos.setId(rid);
		Tjos.setTopic(topic);
		Tjos.setJavapractise_id(javapractise_id);
		Tjos.setIsture(isture);
		optionsService.addmodify(topic,javapractise_id,isture, rid);
		return "redirect:/teachers";
	}
}
