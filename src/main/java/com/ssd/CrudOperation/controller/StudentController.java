package com.ssd.CrudOperation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.CrudOperation.entity.Student;
import com.ssd.CrudOperation.repository.Studentrepository;
import com.ssd.CrudOperation.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student>  saveStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
		}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		 Optional<Student> studentOptional = studentService.getStudentById(id);
	        if (studentOptional.isPresent()) {
	            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		
	}
	
	 @PutMapping("/updateStudent/{id}")
		
		  public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student updatedStudent) { 
		 return studentService.updateStudent(id, updatedStudent); }
		 
	 
	 
	 
	 @DeleteMapping("/deleteStudent/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
	        return studentService.deleteStudent(id);
	    }
	    

}
