package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.AppointmentCenterDTO;
import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.AppointmentStatusDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.GetFreeAppointmentsDTO;
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

	List<GetFreeAppointmentsDTO> getFreeAppointment(Integer adminId);

	Boolean setPatientStatus(AppointmentStatusDTO appointment);
	
	Boolean cancelAppointment(Integer appointmentId);
	
	AppointmentDTO findAppointmentById(Integer id);

	//List<Appointment> getUsersAppointmentHistory(Integer userId);

}
