package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.UserMapper;
import online.shixun.project.pojo.UserPojo;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	public UserPojo getUserById(String name,String password) {
		
		return userMapper.getUserById(name,password);
	}

}
