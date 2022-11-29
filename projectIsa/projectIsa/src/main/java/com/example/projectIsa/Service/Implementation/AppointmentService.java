package com.example.projectIsa.Service.Implementation;

import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Repository.AppointmentsRepository;
import com.example.projectIsa.Repository.CenterAddressRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.Service.IAppointmentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{
	
	private final AppointmentsRepository appointmentRepository;
	private final UserRepository userRepository;
	private final CenterRepository centerRepository;
	private final CenterAddressRepository centerAddressRepository;
	
	public AppointmentService(AppointmentsRepository appointmentRepository, 
			UserRepository userRepository, CenterRepository centerRepository,
			CenterAddressRepository centerAddressRepository) {
		this.appointmentRepository = appointmentRepository;
		this.userRepository = userRepository;
		this.centerRepository = centerRepository;
		this.centerAddressRepository = centerAddressRepository;
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

	@Override
	public List<CentersDTO> findAppointment(String date) {
		LocalDateTime dateTime = LocalDateTime.parse(date);
		List<CentersDTO> allCenters = new ArrayList<>();
		List<Appointment> allAppointmnets = appointmentRepository.findAllByDate(dateTime);
		
		if(allAppointmnets.isEmpty()) {
			return allCenters;
		}else {
			for(Appointment appointment: allAppointmnets) {
				if(!appointment.isTaken()) {
					List<Center> centers = centerRepository.findAllById(appointment.getCenter().getId());
					CentersDTO centersDTO = new CentersDTO();
					for(int i = 0; i < centers.size(); i++) {
						CenterAddress address = centerAddressRepository.findOneById(centers.get(i).getId());
						centersDTO = new CentersDTO();
						centersDTO.setId(centers.get(i).getId());
						centersDTO.setName(centers.get(i).getName());
						centersDTO.setDescription(centers.get(i).getDescription());
						centersDTO.setRating(centers.get(i).getRating());
						centersDTO.setStreet(address.getStreet());
						centersDTO.setHouseNumber(address.getHouseNumber());
						centersDTO.setCity(address.getCity());
						centersDTO.setState(address.getState());
						centersDTO.setPostcode(address.getPostcode());
						allCenters.add(centersDTO);
					}
				}
		}
		
		return allCenters;
		
	  }
	}

}
