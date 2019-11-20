package online.shixun.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MakeMapper {

	@Insert("INSERT INTO `make` (`answer_istrue`, `answer_id`) VALUES ( #{s}, #{answer_id})")
	public void input(int s, int answer_id) ;
}
