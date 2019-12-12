package com.alpha.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.controller.v1.request.GetTripSchedulesRequest;
import com.alpha.dto.TripDto;
import com.alpha.payload.Response;
import com.alpha.service.BusReservationService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * @author Anchal.Mathur
 *
 */

@RestController
@RequestMapping("/api/v1/reservation")
@Api(value = "reservation-service", description = "Operations pertaining to agency management and ticket issue in the BRS application")
public class ReservationController {
	
	@Autowired
    private BusReservationService busReservationService;
	

    @GetMapping("/stops")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "apiKey")})
    public ResponseEntity<?> getAllStops() {
        return new ResponseEntity(busReservationService.getAllStops(),HttpStatus.OK);
        
    }
    
   

}
 