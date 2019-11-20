package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.EvaluatMapper;
import online.shixun.project.pojo.Evaluate;

@Service
public class EvaluateService {

	@Autowired
	EvaluatMapper evaluatMapper;
	public List<Evaluate> gatallEvaluateT(int id, int EvaluateId) {
		
		return evaluatMapper.gatallEvaluateT(id,EvaluateId);
	}
	public List<Evaluate> gatEvaluateById() {
		
		return evaluatMapper.gatEvaluateById();
	}
	public int getpractiseidsById(int attrids) {
		
		return evaluatMapper.getpractiseidsById(attrids);
	}

}
