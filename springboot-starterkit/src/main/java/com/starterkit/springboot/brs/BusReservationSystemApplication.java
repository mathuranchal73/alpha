package com.starterkit.springboot.brs;

import com.starterkit.springboot.brs.model.bus.*;
import com.starterkit.springboot.brs.model.user.Role;
import com.starterkit.springboot.brs.model.user.User;
import com.starterkit.springboot.brs.repository.bus.*;
import com.starterkit.springboot.brs.repository.user.RoleRepository;
import com.starterkit.springboot.brs.repository.user.UserRepository;
import com.starterkit.springboot.brs.util.DateUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BusReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusReservationSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
                           StopRepository stopRepository, AgencyRepository agencyRepository,
                           BusRepository busRepository, TripRepository tripRepository,
                           TripScheduleRepository tripScheduleRepository) {
        return args -> {
            //Create Admin and Passenger Roles
            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRole("ADMIN");
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByRole("PASSENGER");
            if (userRole == null) {
                userRole = new Role();
                userRole.setRole("PASSENGER");
                roleRepository.save(userRole);
            }

            //Create an Admin user
            User admin = userRepository.findByEmail("admin.agencya@gmail.com");
            if (admin == null) {
                admin = new User();
                        admin.setEmail("admin.agencya@gmail.com");
                		admin.setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO"); // "123456"
                		admin.setFirstName("John");
                		admin.setLastName("Doe");
                		admin.setMobileNumber("9425094250");
                		admin.setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(admin);
            }

            //Create four stops
            Stop stopA = stopRepository.findByCode("STPA");
            if (stopA == null) {
                stopA = new Stop();
                stopA.setName("Stop A");
                stopA.setDetail("Near hills");
                stopA.setCode("STPA");
                stopRepository.save(stopA);
            }

            Stop stopB = stopRepository.findByCode("STPB");
            if (stopB == null) {
                stopB = new Stop();
                		stopB.setName("Stop B");
                		stopB.setDetail("Near river");
                		stopB.setCode("STPB");
                stopRepository.save(stopB);
            }

            Stop stopC = stopRepository.findByCode("STPC");
            if (stopC == null) {
                stopC = new Stop();
                		stopC.setName("Stop C");
                		stopC.setDetail("Near desert");
                		stopC.setCode("STPC");
                stopRepository.save(stopC);
            }

            Stop stopD = stopRepository.findByCode("STPD");
            if (stopD == null) {
                stopD = new Stop();
                		stopD.setName("Stop D");
                		stopD.setDetail("Near lake");
                		stopD.setCode("STPD");
                stopRepository.save(stopD);
            }

            //Create an Agency
            Agency agencyA = agencyRepository.findByCode("AGENCYA");
            if (agencyA == null) {
                agencyA = new Agency();
                		agencyA.setName("Green Mile Agency");
                		agencyA.setCode("AGENCYA");
                		agencyA.setDetails("Reaching desitnations with ease");
                		agencyA.setOwner(admin);
                agencyRepository.save(agencyA);
            }

            //Create a bus
            Bus busA = busRepository.findByCode("AGENCYA-1");
            if (busA == null) {
                busA = new Bus();
                busA.setCode("AGENCYA-1");
                busA.setAgency(agencyA);
                busA.setCapacity(60);
                busRepository.save(busA);
            }

            //Add busA to set of buses owned by Agency 'AGENCYA'
            if (agencyA.getBuses() == null) {
                Set<Bus> buses = new HashSet<>();
                agencyA.setBuses(buses);
                agencyA.getBuses().add(busA);
                agencyRepository.save(agencyA);
            }

            //Create a Trip
            Trip trip = tripRepository.findBySourceStopAndDestStopAndBus(stopA, stopB, busA);
            if (trip == null) {
                trip = new Trip();
                		trip.setSourceStop(stopA);
                		trip.setDestStop(stopB);
                		trip.setBus(busA);
                		trip.setAgency(agencyA);
                		trip.setFare(100);
                		trip.setJourneyTime(60);
                tripRepository.save(trip);
            }

            //Create a trip schedule
            TripSchedule tripSchedule = tripScheduleRepository.findByTripDetailAndTripDate(trip, DateUtils.todayStr());
            if (tripSchedule == null) {
                tripSchedule = new TripSchedule();
                		tripSchedule.setTripDetail(trip);
                		tripSchedule.setTripDate(DateUtils.todayStr());
                		tripSchedule.setAvailableSeats(trip.getBus().getCapacity());
                tripScheduleRepository.save(tripSchedule);
            }
        };
    }
}
