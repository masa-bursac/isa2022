package com.example.projectIsa.Service.Implementation;

import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.GetFreeAppointmentsDTO;
import com.example.projectIsa.DTO.TakenAppointmentDTO;
import com.example.projectIsa.DTO.ResponseDTO;
import com.example.projectIsa.DTO.ScheduleAppointmentDTO;
import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.PatientAbilityForAppointmentStatus;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AnsweredSurveyRepository;
import com.example.projectIsa.Repository.AppointmentsRepository;
import com.example.projectIsa.Repository.CenterAddressRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.SurveyRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.DTO.AppointmentCenterDTO;
import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.AppointmentStatusDTO;
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
	private final EmailService emailService;
	private final AnsweredSurveyRepository ansRepository;
	
	public AppointmentService(AppointmentsRepository appointmentRepository, 
			UserRepository userRepository, CenterRepository centerRepository,
			CenterAddressRepository centerAddressRepository, EmailService emailService,
			AnsweredSurveyRepository ansRepository) {
		this.appointmentRepository = appointmentRepository;
		this.userRepository = userRepository;
		this.centerRepository = centerRepository;
		this.centerAddressRepository = centerAddressRepository;
		this.emailService = emailService;
		this.ansRepository = ansRepository;
	}
	
	@Override
	public Appointment addFreeAppointment(FreeAppointmentDTO appointment) {
		Appointment newAppointment = new Appointment();
		
		for(Appointment a: appointmentRepository.findAllByCenterId(appointment.getCenterId())) {
			if(a.getDate().equals(appointment.getDate())) {
				return newAppointment;
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
					cen.getComplaints().clear();
				}
				returnAppointments.add(appointment);
			}
			}
	
		return returnAppointments;
	}

	@Override
	public List<TakenAppointmentDTO> getTakenAppointments(Integer adminId) {

		CenterAdministrator user = userRepository.findOneById(adminId);
		Center center = centerRepository.findOneById(user.getCenter().getId());
		List<Appointment> appointments = appointmentRepository.findAllByCenterId(center.getId());
		List<TakenAppointmentDTO> appointmentDTOs = new ArrayList<TakenAppointmentDTO>();
		for(Appointment appointment: appointments) {
			if(appointment.isTaken()) {
				TakenAppointmentDTO appointmentDTO = new TakenAppointmentDTO(appointment);
				appointmentDTOs.add(appointmentDTO);
			}
		}
		return appointmentDTOs;
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

	@Override
	public ResponseDTO scheduleAppointment(ScheduleAppointmentDTO appointmentDTO) {
		List<Appointment> allAppointmnets = appointmentRepository.findAllByDate(appointmentDTO.getDate());
		ResponseDTO responseDTO = new ResponseDTO();

		for(Appointment appointment: allAppointmnets) {
			if(!appointment.isTaken() && appointment.getCenter().getId().equals(appointmentDTO.getCenterId())) {
				
				RegisteredUser regUser = userRepository.findOneUserById(appointmentDTO.getUserId());
				
				if(regUser.getGaveBloodDate() != null) {
					if(LocalDateTime.now().isBefore(regUser.getGaveBloodDate().plusMonths(6))) {
						responseDTO.setMessage("You can make an appointment only if you have not donated blood in the last 6 months");
						return responseDTO;
					}
					
				}
				
				if(regUser.getTookSurvey() == null) {
					responseDTO.setMessage("You can make an appointment only if you take survey");
					return responseDTO;
				}else if(regUser.getTookSurvey().plusDays(1).isBefore(LocalDateTime.now())) {
					responseDTO.setMessage("You can make an appointment only if you take survey again");
					return responseDTO;
				}
				
				appointment.setTaken(true);
				appointment.setRegUser(regUser);	
				regUser.setGaveBloodDate(appointmentDTO.getDate());
				
				appointmentRepository.save(appointment);
				
				emailService.scheduleAppointment(regUser.getName(), regUser.getSurname());
				
			}
			
		}
		responseDTO.setMessage("Appointment scheduled successfully, you can see it on your profile page");
		return responseDTO;
	}

	@Override
	public List<AppointmentCenterDTO> getUsersAppointment(Integer userId) {
		List<AppointmentCenterDTO> allAppointmentCenterDTO = new ArrayList<>(); 
		List<Appointment> allAppointmnets = appointmentRepository.findAllByRegUserId(userId);
		
		AppointmentCenterDTO appointmentCenterDTO = new AppointmentCenterDTO();

		for(Appointment appointment: allAppointmnets) {
			if(appointment.isTaken() == true) {
				Center center = centerRepository.findOneById(appointment.getCenter().getId());
				appointmentCenterDTO.setId(appointment.getId());
				appointmentCenterDTO.setDate(appointment.getDate());
				appointmentCenterDTO.setDuration(appointment.getDuration());
				appointmentCenterDTO.setName(center.getName());
				appointmentCenterDTO.setDescription(center.getDescription());
				appointmentCenterDTO.setRating(center.getRating());
				appointmentCenterDTO.setStreet(center.getCenterAddress().getStreet());
				appointmentCenterDTO.setHouseNumber(center.getCenterAddress().getHouseNumber());
				appointmentCenterDTO.setCity(center.getCenterAddress().getCity());
				appointmentCenterDTO.setState(center.getCenterAddress().getState());
				appointmentCenterDTO.setPostcode(center.getCenterAddress().getPostcode());
				allAppointmentCenterDTO.add(appointmentCenterDTO);
			}
		}
		
		return allAppointmentCenterDTO;
	}

	@Override
	public List<GetFreeAppointmentsDTO> getFreeAppointment(Integer adminId) {
		CenterAdministrator user = userRepository.findOneById(adminId);
		Center center = centerRepository.findOneById(user.getCenter().getId());
		List<Appointment> appointments = appointmentRepository.findAllByCenterId(center.getId());
		List<GetFreeAppointmentsDTO> appointmentDTOs = new ArrayList<GetFreeAppointmentsDTO>();
		for(Appointment appointment: appointments) {
			if(!appointment.isTaken()) {
				GetFreeAppointmentsDTO appointmentDTO = new GetFreeAppointmentsDTO();
				appointmentDTO.setId(appointment.getId());
				appointmentDTO.setDate(appointment.getDate());
				appointmentDTO.setDuration(appointment.getDuration());
				appointmentDTOs.add(appointmentDTO);
			}
		}
		return appointmentDTOs;
	}

	@Override
	public Boolean setPatientStatus(AppointmentStatusDTO appointment) {
		RegisteredUser patient = userRepository.findOneUserById(appointment.getPatientId());
		if(appointment.getPatientStatus().equals(PatientAbilityForAppointmentStatus.DIDNT_COME)) {
			patient.setPenals(patient.getPenals() + 1);
		}
		Appointment app = appointmentRepository.findOneAppointmentById(appointment.getId());
		app.setPatientStatus(appointment.getPatientStatus());
		if(userRepository.save(patient) != null && appointmentRepository.save(app) != null) {
        	return true;
        }        
        else
            return false;
	}  

  @Override
	public Boolean cancelAppointment(Integer appointmentId) {
		Appointment app = appointmentRepository.findOneById(appointmentId);
		RegisteredUser user = userRepository.findOneUserById(app.getRegUser().getId());

		if(app.isTaken() && LocalDateTime.now().isBefore(app.getDate().minusDays(1))) {
			app.setTaken(false);
			user.setGaveBloodDate(null);
			appointmentRepository.save(app);
			userRepository.save(user);
			return true;
		} else {
			return false;
		}

	}
  @Override
  public AppointmentDTO findAppointmentById(Integer id) {
  	Appointment appointment = appointmentRepository.findOneById(id);
  	AppointmentDTO returnAppointment = new AppointmentDTO();
  	returnAppointment.setId(appointment.getId());
  	returnAppointment.setDate(appointment.getDate());
  	return returnAppointment;
  }

}
