package com.alpha.event;

import org.springframework.context.ApplicationEvent;

import com.alpha.model.Student;

public class StudentProfileAddEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private Student student;
	private String correlationId;



	public StudentProfileAddEvent(String correlationId, Student student) {
		super(student);
		this.correlationId=correlationId;
		this.student=student;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public String getCorrelationId() {
		return correlationId;
	}



	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	
	

}
