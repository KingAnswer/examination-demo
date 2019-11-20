package online.shixun.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.OptionsMapper;
import online.shixun.project.pojo.javaOptions;

@Service
public class OptionsService {

	@Autowired
	OptionsMapper optionsMapper;
	public void addOptions(String topic, int javapractise_id, int isture) {
		optionsMapper.addOptions(topic, javapractise_id,isture);
		
	}
	public int getById(int id) {
	
		return optionsMapper.getById(id);
	}
	public int getintrue(Integer attrids) {
		// TODO Auto-generated method stub
		return optionsMapper. getintrue(attrids);
	}
	public void addmodify(String topic, int javapractise_id, int isture, int rid) {
		optionsMapper.addmodify( topic,  javapractise_id,  isture, rid);
		
	}
	public int getbyid(String integer) {

		return optionsMapper.getbyid( integer);
	}

}
