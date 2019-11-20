package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.SubjectMapper;
import online.shixun.project.pojo.Answer;
import online.shixun.project.pojo.Subject;

@Service
public class SubjectService {

	@Autowired
	SubjectMapper subjectMapper;

	public Subject getCurrentAnswer(int subjectNo, int id) {
		return subjectMapper.getCurrentAnswer(subjectNo,id);
	}

	public List<Subject> getallAnswer(int id, int subjectId) {

		return subjectMapper.getallAnswer(id, subjectId);
	}

	public List<Subject> getsubjectById() {

		return subjectMapper.getsubjectById();
	}
}
