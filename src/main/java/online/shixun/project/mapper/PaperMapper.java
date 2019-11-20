package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.PaperPojo;

@Mapper
public interface PaperMapper {

	@Select("SELECT id,name from paper")
	List<PaperPojo> getAllpaper();

	@Select("SELECT id,name From paper_inquiry")
	List<PaperPojo> getAllpaperInquiry();

	@Select("SELECT id,name From paper_practise")
	List<PaperPojo> getAllpaperPractise();

	@Select("SELECT id,name From paper_rank")
	List<PaperPojo> getAllpaperRank();

	@Select("SELECT id,name From paper_practise WHERE id=#{id} AND name=#{name}")
	List<PaperPojo> getpractise(int id, String name);

}
