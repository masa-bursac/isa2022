package com.example.projectIsa.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.Service.IAppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private final IAppointmentService appointmentService;
	
	public AppointmentController(IAppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping(value = "/addFreeAppointment")
    public ResponseEntity registerCenter(@RequestBody FreeAppointmentDTO appointment) {
        try {
        	return new ResponseEntity(appointmentService.addFreeAppointment(appointment), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
