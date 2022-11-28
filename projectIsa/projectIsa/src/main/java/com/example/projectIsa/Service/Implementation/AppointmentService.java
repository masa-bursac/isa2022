package com.example.projectIsa.Service.Implementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Role;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AppointmentsRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.DTO.AppointmentDTO;
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
		
		for(Appointment a: appointmentRepository.findAllByCenterId(appointment.getCenterId())) {
			if(a.getDate().equals(appointment.getDate())) {
				for(CenterAdministrator ca: a.getCenterAdmin()) {
					for(Integer ids: appointment.getStaffIds()) {
						if(ca.getId().equals(ids)) {
							return newAppointment;
						}
					}
				}
			}
		}
		
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

	@Override
	public List<AppointmentDTO> getAllAppointments(Integer centerId) {
		List<AppointmentDTO> returnAppointments = new ArrayList<AppointmentDTO>();
		
		for(Appointment a: appointmentRepository.findAllByCenterId(centerId)) {
			if(!a.isTaken()) {
				AppointmentDTO appointment = new AppointmentDTO();
				appointment.setDate(a.getDate());
				appointment.setDuration(a.getDuration());
				appointment.setId(a.getId());
				appointment.setStaff(new ArrayList<CenterAdministrator>());
				for(Integer i = 1; i<=userRepository.count(); i++) {
						CenterAdministrator ca = userRepository.findOneById(i);
						
						if(ca!=null)
						{
							for(Appointment ap: ca.getAppointment()) {	
								if(ap.getId().equals(a.getId())) {
									appointment.getStaff().add(ca);
								}
							}
						}
				}			
				for(CenterAdministrator cen: appointment.getStaff()) {
					cen.setCenter(null);
				}
				returnAppointments.add(appointment);
			}
			}
	
		return returnAppointments;
	}

}
