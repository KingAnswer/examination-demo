package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.UserPojo;

@Mapper
public interface UserMapper {

	@Select("select name,password from student where name=#{name} AND password=#{password}")
	public UserPojo getUserById(String name,String password);

}
