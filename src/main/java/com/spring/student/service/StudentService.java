package com.spring.student.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.student.dao.StudentDao;
import com.spring.student.model.Student;


@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	public List<Student> getStudentData()
	{
		List<Student> stList = dao.getStudentData();
		return stList;
	}
	
	
public Student getStudentDataBasedOnId(int id) {
	
	List<Student> stList =dao.getStudentData();
	Optional<Student> student =stList.stream().filter(studen -> (studen.getId() == id)).findFirst();
	System.out.println(student.get());
	return student.get();
	
	                                                                                                                        //return stList.get(0);
}
public boolean addStudentToDb(Student st) {
	boolean status=dao.addStudentToDb(st);
	return status;
}

public boolean deleteStudentFromDb(Long id) {
	boolean status = dao.deleteStudentFromDb(id);
	return status;
	
}
}
	


