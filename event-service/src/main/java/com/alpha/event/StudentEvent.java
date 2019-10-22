package com.alpha.event;

import org.springframework.context.ApplicationEvent;

import com.alpha.model.Student;

public class StudentEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	
	private String correlationId;
    private String eventType;
    private Student student;

    public StudentEvent(String correlationId, String eventType, Student student)
    {
        //Calling this super class constructor is necessary
        super(student);
        this.correlationId=correlationId;
        this.eventType = eventType;
        this.student = student;
    }

    
	public String getCorrelationId() {
		return correlationId;
	}


	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}


	public String getEventType() {
		return eventType;
	}

	public Student getStudent() {
		return student;
	}
    
    
}
