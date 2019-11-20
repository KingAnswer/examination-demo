package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.Evaluate;

@Mapper
public interface EvaluatMapper {

	List<Evaluate> gatallEvaluateT(int id, int EvaluateId);

	List<Evaluate> gatEvaluateById();

	@Select("SELECT fraction FROM evaluate_topic WHERE id=#{attrids}")
	int getpractiseidsById(int attrids);

}
