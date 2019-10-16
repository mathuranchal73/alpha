package com.alpha.web.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alpha.web.RequestCorrelation;



@Component
public class RestClientImpl implements RestClient {
	
	private static Logger logger = Logger.getLogger(RestClientImpl.class);

	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${service.student-service.serviceId}")
    private String studentServiceServiceId;
    
	@Value("${system.userid")
	private final String systemUserId;
	
	@Value("${system.password")
	private final String systemPassword;
	

	@Override
	public ResponseEntity<?> postStudentService(String token, Student student)
	{
		 String correlationId = RequestCorrelation.getId();
		 HttpHeaders httpHeaders = new HttpHeaders();
	     httpHeaders.set(RequestCorrelation.CORRELATION_ID_HEADER, correlationId);
	     httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	     httpHeaders.set("Authorization", token);
	     HttpEntity<Student> entity = new HttpEntity<Long>(student,httpHeaders);
		 Application application = eurekaClient.getApplication(eventServiceServiceId);
		 InstanceInfo instanceInfo = application.getInstances().get(0);
			String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/v1/event/";
			
			ResponseEntity<Student> json;
			try {
					json = restTemplate.exchange(url,HttpMethod.GET, entity, Student.class);
					return json.getBody();
				 
			} catch (RestClientException e) 
			{
				logger.error("Error returning Student Object",e.getStackTrace());
				return null;
			}
	}
	
	
}

