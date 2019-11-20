package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import online.shixun.project.pojo.Answer;


@Mapper
public interface AnswerMapper {

	List<Answer> gatradio(Integer hiddenId);
	
}
