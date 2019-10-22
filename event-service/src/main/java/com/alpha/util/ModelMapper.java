package com.alpha.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alpha.model.Student;
import com.alpha.model.User;
import com.alpha.web.RequestCorrelation;

@Component
public class ModelMapper {
	
	private static Logger logger = Logger.getLogger(ModelMapper.class);
	
	public Student mapUserObjecttoStudent(HttpServletRequest request, User user) {
		
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
