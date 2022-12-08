package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.AppointmentCenterDTO;
import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.TakenAppointmentDTO;
import com.example.projectIsa.DTO.ResponseDTO;
import com.example.projectIsa.DTO.ScheduleAppointmentDTO;
import com.example.projectIsa.Model.Appointment;

public interface IAppointmentService {

	Appointment addFreeAppointment(FreeAppointmentDTO appointment);

	List<AppointmentDTO> getAllAppointments(Integer centerId);

	List<TakenAppointmentDTO> getTakenAppointments(Integer adminId);
	
	List<CentersDTO> findAppointment(String date);

	ResponseDTO scheduleAppointment(ScheduleAppointmentDTO appointment);

	List<AppointmentCenterDTO> getUsersAppointment(Integer userId);
}
