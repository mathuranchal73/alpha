package com.alpha.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alpha.model.Student;
import com.alpha.model.User;
import com.alpha.payload.UserRequest;
import com.alpha.web.RequestCorrelation;

@Component
public class ModelMapper {
	
	private static Logger logger = LoggerFactory.getLogger(ModelMapper.class);
	
	public Student mapUserObjecttoStudent(HttpServletRequest request, UserRequest user) {
		
		Student	student = new Student();
		student.setFirstName("Guest");
		student.setLastName("User");
		student.setCountry_cd(request.getHeader("CountryCD"));
		student.setSource_cd(request.getHeader("SourceAppCD"));
		student.setUuid(user.getUuid());
		
		logger.info(request.getHeader(RequestCorrelation.CORRELATION_ID_HEADER)+": Mapped User Object to Student Object Successfully");
		return student;
		
	}

}
