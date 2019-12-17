package com.alpha.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alpha.dto.GeoLocation;
import com.alpha.dto.UserAgentDetails;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

import eu.bitwalker.useragentutils.UserAgent;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import static java.util.Objects.nonNull;

/**
 * @author Anchal.Mathur
 *
 */

@Service
public class VisitorServiceImpl implements VisitorService {
	
	private DatabaseReader dbReader;

	public VisitorServiceImpl()throws IOException {
		 	File database = new File("./GeoLite2-City.mmdb");
	        dbReader = new DatabaseReader.Builder(database).build();
	}

	
	
    
	@Override
	public GeoLocation getGeoLocationFromIpAddress(InetAddress ipAddress)throws IOException, GeoIp2Exception {
		
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();
        String postalCode=response.getPostal().getCode();
        String countryName=response.getCountry().getName();
        String countryCode=response.getCountry().getIsoCode();
        String region=response.getContinent().getName();
        return new GeoLocation(countryCode,countryName,postalCode,cityName,region,latitude,longitude);
	}


	private static final String[] IP_HEADER_CANDIDATES = { 
		    "X-Forwarded-For",
		    "Proxy-Client-IP",
		    "WL-Proxy-Client-IP",
		    "HTTP_X_FORWARDED_FOR",
		    "HTTP_X_FORWARDED",
		    "HTTP_X_CLUSTER_CLIENT_IP",
		    "HTTP_CLIENT_IP",
		    "HTTP_FORWARDED_FOR",
		    "HTTP_FORWARDED",
		    "HTTP_VIA",
		    "REMOTE_ADDR" };


	public  String  extractIpAddress(HttpServletRequest request) {
		for (String header : IP_HEADER_CANDIDATES) {
	        String ip = request.getHeader(header);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    return request.getRemoteAddr();
		
		
	}

	        


   /** private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }**/




	@Override
	public UserAgentDetails getUserAgentDetails(HttpServletRequest request) {
		
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		System.out.println(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion());
		String browserName= userAgent.getBrowser().getName();
		String browserVersion=userAgent.getBrowserVersion().getMajorVersion();
		String engineName=userAgent.getBrowser().getRenderingEngine().getName();
		String osName=userAgent.getOperatingSystem().getName();
		int osVersion=userAgent.getOperatingSystem().getId();
		String deviceModel=userAgent.getOperatingSystem().getManufacturer().getName();
		String deviceType=userAgent.getOperatingSystem().getDeviceType().getName();
		
		return new UserAgentDetails(browserName,browserVersion,engineName,osName,osVersion,deviceModel,deviceType);
	}
	
	
	

}
