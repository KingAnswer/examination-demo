package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.JavapractiseMapper;
import online.shixun.project.pojo.javapractise;

@Service
public class JavapractiseService {

	@Autowired
	JavapractiseMapper javapractiseMapper;
	
	public List<javapractise> getallpractise(int id, int practiseNo) {
			
		return javapractiseMapper.getallpractise(id, practiseNo);
	}

	public List<javapractise> getallTpractise() {
		
		return javapractiseMapper.getallTpractise();
	}

	public void addPractise(String name) {
	
		javapractiseMapper.addPractise(name);
	}

	public List<javapractise> getall() {
	
		return javapractiseMapper.getall();
	}

	public List<javapractise> getallrevise(int id) {
	
		return javapractiseMapper.getallrevise(id);
	}

	public void addjavamodify(int id, String name) {
		javapractiseMapper.addjavamodify(id, name);
		
	}

}
