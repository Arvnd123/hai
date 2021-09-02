package com.spring.student.controllers;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.model.Student;
import com.spring.student.service.StudentService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/student")

public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping(value="/studentinfo", method=RequestMethod.GET)
	public List<Student> getStudentInfo(){
		List<Student> li=service.getStudentData();
		return li;	
	}
	
@RequestMapping(value ="/postStudentData", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)

public Student studentPostCall(@RequestBody Student student)
{
	//validation
	if(Objects.isNull(student.getId())|| (student.getId()==0)) {
		throw new IllegalArgumentException("Student id is needed");
	}
	
	//service
	Student studentObj= service.getStudentDataBasedOnId(student.getId());
	return studentObj;
}

@RequestMapping(value ="/putStudentData", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
 
public String putStudentData(@RequestBody Student st) {
	
	boolean status = service.addStudentToDb(st);
	if(status==true) {
		
		return "student added ";
	}
	else
	{
		return "student not added";
		
	}
	
}
@RequestMapping(value ="/dltStudentData/{id}", method= RequestMethod.DELETE)


public String deleteStudentData(@PathVariable Long id)  {
	boolean status = service.deleteStudentFromDb(id);
	
	if(status==true) {
		return "dltd ";
	}
	else
	{
		return "not dltd";
		
	}
	
}
}


	




