package com.example.projectIsa.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.AppointmentCenterDTO;
import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.AppointmentStatusDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.GetFreeAppointmentsDTO;
import com.example.projectIsa.DTO.TakenAppointmentDTO;
import com.example.projectIsa.DTO.ScheduleAppointmentDTO;
import com.example.projectIsa.Service.IAppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private final IAppointmentService appointmentService;
	
	public AppointmentController(IAppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping(value = "/addFreeAppointment")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity addFreeAppointment(@RequestBody FreeAppointmentDTO appointment) {
        try {
        	return new ResponseEntity(appointmentService.addFreeAppointment(appointment), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/getAllFreeAppointments/{centerId}")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public List<AppointmentDTO> getAllAppointments(@PathVariable Integer centerId) {
        return appointmentService.getAllAppointments(centerId);
    }
	
	@GetMapping("/getTakenAppointment/{adminId}")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity<List<TakenAppointmentDTO>> getTakenAppointment(@PathVariable Integer adminId) {
        return new ResponseEntity<List<TakenAppointmentDTO>>(appointmentService.getTakenAppointments(adminId), HttpStatus.OK);
    }
    
	@GetMapping("/findAppointment/{date}")
	@PreAuthorize("hasRole('ROLE_REGISTERED')")
    public List<CentersDTO> findAppointment(@PathVariable String date) {
        return appointmentService.findAppointment(date);
    }
	
	@PostMapping(value = "/scheduleAppointment")
	@PreAuthorize("hasRole('ROLE_REGISTERED')")
    public ResponseEntity scheduleAppointment(@RequestBody ScheduleAppointmentDTO appointment) {
        return new ResponseEntity(appointmentService.scheduleAppointment(appointment), HttpStatus.OK);
    }
	
	@GetMapping("/getUsersAppointment/{userId}")
	@PreAuthorize("hasAnyRole('ROLE_REGISTERED','ROLE_CENTERADMIN')")
    public List<AppointmentCenterDTO> getUsersAppointment(@PathVariable Integer userId) {
        return appointmentService.getUsersAppointment(userId);
    }
	
	@GetMapping("/getFreeAppointment/{adminId}")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity<List<GetFreeAppointmentsDTO>> getFreeAppointment(@PathVariable Integer adminId) {
        return new ResponseEntity<List<GetFreeAppointmentsDTO>>(appointmentService.getFreeAppointment(adminId), HttpStatus.OK);
    }
	
	@PutMapping(value = "/setPatientStatus")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity setPatientStatus(@RequestBody AppointmentStatusDTO appointment) {
        try {
        	return new ResponseEntity(appointmentService.setPatientStatus(appointment), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
