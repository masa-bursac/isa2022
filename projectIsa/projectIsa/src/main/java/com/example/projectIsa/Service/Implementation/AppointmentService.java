package com.example.projectIsa.Service.Implementation;

import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Repository.AppointmentsRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IAppointmentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{
	
	private final AppointmentsRepository appointmentRepository;
	private final UserRepository userRepository;
	private final CenterRepository centerRepository;
	
	public AppointmentService(AppointmentsRepository appointmentRepository, 
			UserRepository userRepository, CenterRepository centerRepository) {
		this.appointmentRepository = appointmentRepository;
		this.userRepository = userRepository;
		this.centerRepository = centerRepository;
	}
	
	@Override
	public Appointment addFreeAppointment(FreeAppointmentDTO appointment) {
		Appointment newAppointment = new Appointment();
		newAppointment.setId((int)(appointmentRepository.count() + 1));
		newAppointment.setDate(appointment.getDate());
		newAppointment.setDuration(appointment.getDuration());
		
		
		List<CenterAdministrator> staff = new ArrayList<CenterAdministrator>();
		for(Integer id: appointment.getStaffIds()) {
			CenterAdministrator admin = userRepository.findOneById(id);
			staff.add(admin);
		}
		
		newAppointment.setCenterAdmin(staff);
		
		Center center = centerRepository.findOneById(appointment.getCenterId());
		newAppointment.setCenter(center);
		
		appointmentRepository.save(newAppointment);
	
		return newAppointment;
	}

}
