package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import online.shixun.project.pojo.javapractise;

@Mapper
public interface JavapractiseMapper {

	public List<javapractise> getallpractise(int id, int practiseNo);

	public List<javapractise> getallTpractise();

	public void addPractise(String name);

	@Select("SELECT a.id,a.name from javapractise a")
	public List<javapractise> getall();

	public List<javapractise> getallrevise(int id);

	//@Insert("INSERT INTO javapractise (id, name) VALUES (#{id},#{name})")
	@Update("UPDATE `javapractise` SET `name`= #{name} WHERE  `id`= #{id}")
	public void addjavamodify(int id, String name);

}
