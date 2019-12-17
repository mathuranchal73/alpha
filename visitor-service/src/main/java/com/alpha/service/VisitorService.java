/**
 * 
 */
package com.alpha.service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.MultiValueMap;

import com.alpha.dto.GeoLocation;
import com.alpha.dto.UserAgentDetails;
import com.maxmind.geoip2.exception.GeoIp2Exception;

/**
 * @author Anchal.Mathur
 *
 */
public interface VisitorService {

	/**
	 * @param ipAddress 
	 * @return
	 * @throws GeoIp2Exception 
	 * @throws IOException 
	 */
	GeoLocation getGeoLocationFromIpAddress(InetAddress ipAddress) throws IOException, GeoIp2Exception;

	
	
	/**
	 * @param request
	 * @return
	 */
	UserAgentDetails getUserAgentDetails(HttpServletRequest request);



	/**
	 * @param request
	 * @return
	 */
	String extractIpAddress(HttpServletRequest request);
	
	

}
