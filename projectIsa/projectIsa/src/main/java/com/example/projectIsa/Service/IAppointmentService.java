package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.Model.Appointment;

public interface IAppointmentService {

	Appointment addFreeAppointment(FreeAppointmentDTO appointment);
}
