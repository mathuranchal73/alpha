package com.starterkit.springboot.brs.controller.v1.ui;

import com.starterkit.springboot.brs.controller.v1.command.*;
import com.starterkit.springboot.brs.dto.model.bus.AgencyDto;
import com.starterkit.springboot.brs.dto.model.bus.BusDto;
import com.starterkit.springboot.brs.dto.model.bus.StopDto;
import com.starterkit.springboot.brs.dto.model.bus.TripDto;
import com.starterkit.springboot.brs.dto.model.user.UserDto;
import com.starterkit.springboot.brs.service.BusReservationService;
import com.starterkit.springboot.brs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private BusReservationService busReservationService;

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @GetMapping(value = "/agency")
    public ModelAndView agencyDetails() {
        ModelAndView modelAndView = new ModelAndView("agency");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        AgencyFormCommand agencyFormCommand = new AgencyFormCommand();
        agencyFormCommand.setAgencyName(agencyDto.getName());
        agencyFormCommand.setAgencyDetails(agencyDto.getDetails());
        modelAndView.addObject("agencyFormData", agencyFormCommand);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/agency")
    public ModelAndView updateAgency(@Valid @ModelAttribute("agencyFormData") AgencyFormCommand agencyFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("agency");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        if (!bindingResult.hasErrors()) {
            if (agencyDto != null) {
                agencyDto.setName(agencyFormCommand.getAgencyName());
                agencyDto.setDetails(agencyFormCommand.getAgencyDetails());
                busReservationService.updateAgency(agencyDto, null);
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/bus")
    public ModelAndView busDetails() {
        ModelAndView modelAndView = new ModelAndView("bus");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("busFormData", new BusFormCommand());
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/bus")
    public ModelAndView addNewBus(@Valid @ModelAttribute("busFormData") BusFormCommand busFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("bus");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        modelAndView.addObject("userName", userDto.getFullName());
        modelAndView.addObject("agency", agencyDto);
        if (!bindingResult.hasErrors()) {
            try {
                BusDto busDto = new BusDto();
                busDto.setCode(busFormCommand.getCode());
                busDto.setCapacity(busFormCommand.getCapacity());
                busDto.setMake(busFormCommand.getMake());
                AgencyDto updatedAgencyDto = busReservationService.updateAgency(agencyDto, busDto);
                modelAndView.addObject("agency", updatedAgencyDto);
                modelAndView.addObject("busFormData", new BusFormCommand());
            } catch (Exception ex) {
                bindingResult.rejectValue("code", "error.busFormCommand", ex.getMessage());
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/trip")
    public ModelAndView tripDetails() {
        ModelAndView modelAndView = new ModelAndView("trip");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        Set<StopDto> stops = busReservationService.getAllStops();
        List<TripDto> trips = busReservationService.getAgencyTrips(agencyDto.getCode());
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("stops", stops);
        modelAndView.addObject("trips", trips);
        modelAndView.addObject("tripFormData", new TripFormCommand());
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/trip")
    public ModelAndView addNewTrip(@Valid @ModelAttribute("tripFormData") TripFormCommand tripFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("trip");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        AgencyDto agencyDto = busReservationService.getAgency(userDto);
        Set<StopDto> stops = busReservationService.getAllStops();
        List<TripDto> trips = busReservationService.getAgencyTrips(agencyDto.getCode());

        modelAndView.addObject("stops", stops);
        modelAndView.addObject("agency", agencyDto);
        modelAndView.addObject("userName", userDto.getFullName());
        modelAndView.addObject("trips", trips);

        if (!bindingResult.hasErrors()) {
            try {
                TripDto tripDto = new TripDto();
                		tripDto.setSourceStopCode(tripFormCommand.getSourceStop());
                		tripDto.setDestinationStopCode(tripFormCommand.getDestinationStop());
                		tripDto.setBusCode(tripFormCommand.getBusCode());
                		tripDto.setJourneyTime(tripFormCommand.getTripDuration());
                		tripDto.setFare(tripFormCommand.getTripFare());
                		tripDto.setAgencyCode(agencyDto.getCode());
                busReservationService.addTrip(tripDto);

                trips = busReservationService.getAgencyTrips(agencyDto.getCode());
                modelAndView.addObject("trips", trips);
                modelAndView.addObject("tripFormData", new TripFormCommand());
            } catch (Exception ex) {
                bindingResult.rejectValue("sourceStop", "error.tripFormData", ex.getMessage());
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/profile")
    public ModelAndView getUserProfile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        ProfileFormCommand profileFormCommand = new ProfileFormCommand();
        		profileFormCommand.setFirstName(userDto.getFirstName());
        		profileFormCommand.setLastName(userDto.getLastName());
        		profileFormCommand.setMobileNumber(userDto.getMobileNumber());
        PasswordFormCommand passwordFormCommand = new PasswordFormCommand();
        passwordFormCommand.setEmail(userDto.getEmail());
        passwordFormCommand.setPassword(userDto.getPassword());
        modelAndView.addObject("profileForm", profileFormCommand);
        modelAndView.addObject("passwordForm", passwordFormCommand);
        modelAndView.addObject("userName", userDto.getFullName());
        return modelAndView;
    }

    @PostMapping(value = "/profile")
    public ModelAndView updateProfile(@Valid @ModelAttribute("profileForm") ProfileFormCommand profileFormCommand, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("profile");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        PasswordFormCommand passwordFormCommand = new PasswordFormCommand();
        		passwordFormCommand.setEmail(userDto.getEmail());
        		passwordFormCommand.setPassword(userDto.getPassword());
        modelAndView.addObject("passwordForm", passwordFormCommand);
        modelAndView.addObject("userName", userDto.getFullName());
        if (!bindingResult.hasErrors()) {
            userDto.setFirstName(profileFormCommand.getFirstName());
            userDto.setLastName(profileFormCommand.getLastName());
            userDto.setMobileNumber(profileFormCommand.getMobileNumber());
            userService.updateProfile(userDto);
            modelAndView.addObject("userName", userDto.getFullName());
        }
        return modelAndView;
    }

    @PostMapping(value = "/password")
    public ModelAndView changePassword(@Valid @ModelAttribute("passwordForm") PasswordFormCommand passwordFormCommand, BindingResult bindingResult) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("profile");
            ProfileFormCommand profileFormCommand = new ProfileFormCommand();
            		userDto.setFirstName(userDto.getFirstName());
            		userDto.setLastName(userDto.getLastName());
            		userDto.setMobileNumber(userDto.getMobileNumber());
            modelAndView.addObject("profileForm", profileFormCommand);
            modelAndView.addObject("userName", userDto.getFullName());
            return modelAndView;
        } else {
            userService.changePassword(userDto, passwordFormCommand.getPassword());
            return new ModelAndView("login");
        }
    }

}
