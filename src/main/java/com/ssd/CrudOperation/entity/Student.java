package com.ssd.CrudOperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@NotEmpty
	@Size(min= 3, max=10)
	@Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Name should contain only letters and spaces")
	private String studentname;
	
	
	@NotEmpty
	@Email
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email format")
	private String studentemail;
	
	@NotEmpty
	@NotNull
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[a-zA-Z0-9\\s]{1,100}$", message = "Address should contain only letters, numbers, and spaces with maximum length of 100")
	private String studentaddress;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentemail() {
		return studentemail;
	}
	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public Student(long id, String studentname, String studentemail, String studentaddress) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.studentemail = studentemail;
		this.studentaddress = studentaddress;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", studentemail=" + studentemail
				+ ", studentaddress=" + studentaddress + "]";
	}

}
