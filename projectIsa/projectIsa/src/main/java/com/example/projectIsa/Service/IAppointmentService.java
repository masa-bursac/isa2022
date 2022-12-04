package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.TakenAppointmentDTO;
import com.example.projectIsa.Model.Appointment;

public interface IAppointmentService {

	Appointment addFreeAppointment(FreeAppointmentDTO appointment);

	List<AppointmentDTO> getAllAppointments(Integer centerId);

	List<TakenAppointmentDTO> getTakenAppointments(Integer adminId);
}
