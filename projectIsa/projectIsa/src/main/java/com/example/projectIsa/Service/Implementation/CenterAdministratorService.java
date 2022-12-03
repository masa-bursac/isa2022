package com.example.projectIsa.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.Appointment;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.Gender;
import com.example.projectIsa.Model.Role;
import com.example.projectIsa.Model.SystemAdminstrator;
import com.example.projectIsa.Repository.CenterAdministratorRepository;
import com.example.projectIsa.Repository.SystemAdministratorRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IAddressService;
import com.example.projectIsa.Service.ICenterAdministratorService;
import com.example.projectIsa.Service.IEducationService;

@Service
public class CenterAdministratorService implements ICenterAdministratorService {

	private final CenterAdministratorRepository centerAdministratorRepository;
    private final PasswordEncoder passwordEncoder;
	private final IEducationService educationService;
	private final IAddressService addressService;
	private final UserRepository userRepository;
	private final SystemAdministratorRepository systemAdministratorRepository;
	
	@Autowired
	public CenterAdministratorService(CenterAdministratorRepository centerAdministratorRepository,
			IEducationService educationService, IAddressService addressService, UserRepository userRepository,
			PasswordEncoder passwordEncoder, SystemAdministratorRepository systemAdminisstratorRepository) {
		this.centerAdministratorRepository = centerAdministratorRepository;
		this.educationService = educationService;
		this.addressService = addressService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.systemAdministratorRepository = systemAdminisstratorRepository;
	}

	@Override
	public boolean addAdmin(CenterAdministratorDTO adminDTO, Center center) {
		// TODO Auto-generated method stub
		CenterAdministrator centerAdmin = new CenterAdministrator(adminDTO);
		centerAdmin.setCenter(center);
		centerAdmin.setId((int) (userRepository.count()+1));
		switch(adminDTO.getGender()) {
			case "Female": centerAdmin.setGender(Gender.FEMALE); break;
			case "Male": centerAdmin.setGender(Gender.MALE); break;
			default: centerAdmin.setGender(Gender.NONBINARY); break;
		}
		centerAdmin.setRole(Role.ROLE_CENTERADMIN);
		centerAdmin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		Address address = addressService.addAddress(adminDTO, centerAdmin);
		centerAdmin.setAddress(address);
		Education education = educationService.addEducation(adminDTO.getEducation(), adminDTO.getProfession(), centerAdmin);
		centerAdmin.setEducation(education);
		education.setUser(centerAdmin);
		centerAdmin.setEducation(education);
		centerAdmin.setHasToChangePass(true);
		centerAdministratorRepository.save(centerAdmin);
		return true;
	}

	@Override
	public List<CenterAdministrator> getAllCentreAdminByCenterId(Integer id) {
		List<CenterAdministrator> returnAdmin = new ArrayList<CenterAdministrator>();
		for(Integer i = 1; i<=userRepository.count(); i++) {
			CenterAdministrator ca = userRepository.findOneById(i);
			
			if(ca!=null && ca.getCenter().getId().equals(id))
			{
				ca.setCenter(null);
				returnAdmin.add(ca);
			}
		}	
		return returnAdmin;
	}

	@Override
	public SystemAdminstrator registerSystemAdmin(CenterAdministratorDTO adminDTO) {
		SystemAdminstrator systemAdmin = new SystemAdminstrator(adminDTO);
		systemAdmin.setId((int) (userRepository.count()+1));
		switch(adminDTO.getGender()) {
			case "Female": systemAdmin.setGender(Gender.FEMALE); break;
			case "Male": systemAdmin.setGender(Gender.MALE); break;
			default: systemAdmin.setGender(Gender.NONBINARY); break;
		}
		systemAdmin.setRole(Role.ROLE_SYSTEMADMIN);
		systemAdmin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		Address address = addressService.addAddress(adminDTO, systemAdmin);
		systemAdmin.setAddress(address);
		Education education = educationService.addEducation(adminDTO.getEducation(), adminDTO.getProfession(), systemAdmin);
		systemAdmin.setEducation(education);
		education.setUser(systemAdmin);
		systemAdmin.setEducation(education);
		systemAdmin.setHasToChangePass(true);
		return systemAdministratorRepository.save(systemAdmin);
	}

}
