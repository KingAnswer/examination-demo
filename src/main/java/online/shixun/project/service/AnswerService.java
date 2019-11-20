package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.AnswerMapper;
import online.shixun.project.pojo.Answer;

@Service
public class AnswerService {

	@Autowired
	AnswerMapper answerMapper;
	public List<Answer> gatradio(Integer hiddenId) {
		return answerMapper.gatradio(hiddenId);
	}

}
