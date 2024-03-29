package com.alpha.web.client;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alpha.model.User;
import com.alpha.payload.AuthRequest;
import com.alpha.payload.AuthResponse;
import com.alpha.web.ApiResponse;
import com.alpha.web.RequestCorrelation;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;



@Component
public class RestClientImpl implements RestClient {
	
	private static Logger logger = Logger.getLogger(RestClientImpl.class);
	
	@Autowired
    private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;

	
	
	@Value("${service.zuul.serviceId}")
    private String zuulServiceId;
	
	@Value("${service.event-service.serviceId}")
    private String eventServiceServiceId;
    
	@Value("${system.userid")
	private final String systemUserId="system";
	
	@Value("${system.password")
	private final String systemPassword="123456";
	
	private String getToken(String systemUserId, String systemPassword) {
		
		 AuthRequest authRequest= new AuthRequest(systemUserId,systemPassword);
		 String correlationId = RequestCorrelation.getId();
		 HttpHeaders httpHeaders = new HttpHeaders();
	     httpHeaders.set(RequestCorrelation.CORRELATION_ID_HEADER, correlationId);
	     httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	     HttpEntity<AuthRequest> entity = new HttpEntity<AuthRequest>(authRequest,httpHeaders);
		 Application application = eurekaClient.getApplication(zuulServiceId);
		 InstanceInfo instanceInfo = application.getInstances().get(0);
		 String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/api/signin";
			
			ResponseEntity<AuthResponse> json;
			try {
					json = restTemplate.exchange(url,HttpMethod.POST, entity, AuthResponse.class);
					return json.getBody().getAccessToken();
				 
			} catch (RestClientException e) 
			{
				logger.error(correlationId+":" +"Zuul Error"+e.getStackTrace());
				return null;
			}
		
	}
	

	@Override
	public ResponseEntity<ApiResponse> postStudentService(HttpServletRequest request,User result)
	{
		 String correlationId = RequestCorrelation.getId();
		 HttpHeaders httpHeaders = new HttpHeaders();
	     httpHeaders.set(RequestCorrelation.CORRELATION_ID_HEADER, correlationId);
	     httpHeaders.set("CountryCD", request.getHeader("CountryCD"));
	     httpHeaders.set("SourceAppCD", request.getHeader("SourceAppCD"));
	     httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	     httpHeaders.set("Authorization", getToken(systemUserId,systemPassword));
	     HttpEntity<User> entity = new HttpEntity<User>(result,httpHeaders);
		 Application application = eurekaClient.getApplication(eventServiceServiceId);
		 InstanceInfo instanceInfo = application.getInstances().get(0);
			String url = "http://"+instanceInfo.getIPAddr()+ ":"+instanceInfo.getPort()+"/v1/event/";
			try {
				ResponseEntity<ApiResponse> json = restTemplate.exchange(url,HttpMethod.POST, entity, ApiResponse.class);
				logger.info(correlationId+":"+"Posted User details to Event Service");
				return json;
				 
			} catch (RestClientException e) 
			{
				logger.error(correlationId+":"+"Error returning Student Object"+ e.getStackTrace());
				return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Error returning Student Object"),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	
}

