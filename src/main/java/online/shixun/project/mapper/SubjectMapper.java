package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import online.shixun.project.pojo.Subject;

@Mapper
public interface SubjectMapper {


	Subject getCurrentAnswer(int id, int subjectNo);

	List<Subject> getallAnswer(int id, int subjectId);

	List<Subject> getsubjectById();

}
