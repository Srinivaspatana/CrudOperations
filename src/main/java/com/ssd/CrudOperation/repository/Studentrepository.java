package com.ssd.CrudOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.CrudOperation.entity.Student;

public interface Studentrepository extends JpaRepository<Student, Long> {
	
	

}
