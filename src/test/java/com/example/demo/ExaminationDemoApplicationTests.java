package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import online.shixun.project.pojo.javapractise;
import online.shixun.project.service.JavapractiseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationDemoApplicationTests {

	@Autowired
	JavapractiseService javapractiseService;
	@Test
	public void contextLoads(int id) {
		List<javapractise> javarevise = javapractiseService.getallrevise(id);
		System.out.println(javarevise);
	}

}
