package com.alpha.controller.v1;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.service.VisitorService;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * @author Anchal.Mathur
 *
 */

@RestController
@RequestMapping("/api/v1/visitor")
@Api(value = "visitor-service", description = "Extracts Visitor Information")
public class VisitorController {
	
	@Autowired
	VisitorService visitorService;
	
	@GetMapping("/getIpAddress")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<?> getIpAddress(HttpServletRequest request){
        return new ResponseEntity(visitorService.extractIpAddress(request),HttpStatus.OK);
        
    }
	
	@GetMapping("/geolocations/{ipAddress}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<?> getGeoLocation(@PathVariable String ipAddress) throws IOException, GeoIp2Exception {
        return new ResponseEntity(visitorService.getGeoLocationFromIpAddress(InetAddress.getByName(ipAddress)),HttpStatus.OK);
        
    }
	
	/**@GetMapping("/useragents/{userAgent}")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<?> getGeoLocation(@PathVariable String ipAddress) throws IOException, GeoIp2Exception {
        return new ResponseEntity(visitorService.getGeoLocationFromIpAddress(InetAddress.getByName(ipAddress)),HttpStatus.OK);
        
    }
	**/

}
