package online.shixun.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.MakeMapper;

@Service
public class MakeService {

	@Autowired
	MakeMapper makeMapper;
	public void input(int s, int answer_id) {
		
		makeMapper.input(s,answer_id);
	}

}
