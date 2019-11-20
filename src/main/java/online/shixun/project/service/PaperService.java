package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.PaperMapper;
import online.shixun.project.pojo.PaperPojo;

@Service
public class PaperService {

	@Autowired
	PaperMapper paperMapper;
	public List<PaperPojo> getAllpaper() {
		
		return paperMapper.getAllpaper();
	}
	public List<PaperPojo> getAllpaperInquiry() {
		
		return paperMapper.getAllpaperInquiry();
	}
	public List<PaperPojo> getAllpaperPractise() {

		return paperMapper.getAllpaperPractise();
	}
	public List<PaperPojo> getAllpaperRank() {
	
		return paperMapper.getAllpaperRank();
	}
	public List<PaperPojo> getpractise(int id, String name) {
		// TODO Auto-generated method stub
		return paperMapper. getpractise(id, name);
	}
}
