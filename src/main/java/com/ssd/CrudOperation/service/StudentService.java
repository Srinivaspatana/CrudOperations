package com.ssd.CrudOperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssd.CrudOperation.entity.Student;
import com.ssd.CrudOperation.repository.Studentrepository;

@Service
public class StudentService {
	@Autowired
	private Studentrepository studentrepository;
	
	
	 public Student saveStudent(Student student) {
	        return studentrepository.save(student);
	    }
	 
	 public List<Student> getAllStudents() {
	        return studentrepository.findAll();
	    }
	 
	 
	 public Optional<Student> getStudentById(long id) {
	        return studentrepository.findById(id);
	    }
	 
	 public ResponseEntity<Student> updateStudent(long id, Student updatedStudent) {
	        Optional<Student> studentUpdated = studentrepository.findById(id);
	        if (studentUpdated.isPresent()) {
	            Student existingStudent = studentUpdated.get();
	            existingStudent.setStudentname(updatedStudent.getStudentname());
	            existingStudent.setStudentemail(updatedStudent.getStudentemail());
	            existingStudent.setStudentaddress(updatedStudent.getStudentaddress());
	            Student savedStudent = studentrepository.save(existingStudent);
	            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 public ResponseEntity<Void> deleteStudent(long id) {
	        Optional<Student> studentToDelete = studentrepository.findById(id);
	        if (studentToDelete.isPresent()) {
	        	studentrepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	
	

}
