package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//@RequestMapping(value ="/students")
	@GetMapping(value ="/students")
	public List<String> getStudents(@RequestParam(required=false) String word){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Vasea Pecus");
		list.add("John Travolta");
		list.add("Student 3");
		return list
				.stream()
				.filter(name -> word != null?name.contains(word):true)
				.collect(Collectors.toList());
		
	}
	
	@PostMapping(value="/students/create")
	public String createStudent(@RequestParam String name) {
		
		String student =name;
		System.out.println(student);
		return student;
		
	}
}
