package online.shixun.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import online.shixun.project.pojo.javaOptions;


@Mapper
public interface OptionsMapper {

	void addOptions(String topic, int javapractise_id, int isture);

	@Select("SELECT isture FROM java_options WHERE id=#{id}")
	int getById(int id);

	@Select("SELECT isture FROM java_options WHERE id=#{attrids}")
	int getintrue(Integer attrids);

	//@Insert("INSERT INTO`java_options` ( `topic`, `javapractise_id`, `istrue`) VALUES ( #{topic}, #{javapractise_id}, #{isture})")
	@Update("UPDATE `java_options` SET `topic`=#{topic}, `javapractise_id`=#{javapractise_id}, `isture`=#{isture} WHERE  `id=#{rid}")
	void addmodify(String topic, int javapractise_id, int isture, int rid);
	
	int getbyid(String integer);

}
