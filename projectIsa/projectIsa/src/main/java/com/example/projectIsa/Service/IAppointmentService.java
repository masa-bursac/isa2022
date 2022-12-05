package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.ScheduleAppointmentDTO;
import com.example.projectIsa.Model.Appointment;

public interface IAppointmentService {

	Appointment addFreeAppointment(FreeAppointmentDTO appointment);

	List<AppointmentDTO> getAllAppointments(Integer centerId);
	
	List<CentersDTO> findAppointment(String date);

	Boolean scheduleAppointment(ScheduleAppointmentDTO appointment);
}
