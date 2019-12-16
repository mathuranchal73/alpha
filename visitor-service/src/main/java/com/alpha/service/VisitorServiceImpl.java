/**
 * 
 */
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
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
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




	@Override
	 public Map<String, String>  extractIpAddress(HttpServletRequest request) {
        /**String clientIp;
        String clientXForwardedForIp = request.getHeader("x-forwarded-for");
        if (nonNull(clientXForwardedForIp)) {
           // clientIp = parseXForwardedHeader(clientXForwardedForIp);
        	//clientIp=clientXForwardedForIp;
        	clientIp=request.getRemoteAddr();
        } else {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;**/
		
		
	

	        Map<String, String> result = new HashMap<>();

	        Enumeration headerNames = request.getHeaderNames();
	        while (headerNames.hasMoreElements()) {
	            String key = (String) headerNames.nextElement();
	            String value = request.getHeader(key);
	            result.put(key, value);
	        }

	        return result;
	    }


    private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }
	
	
	

}
