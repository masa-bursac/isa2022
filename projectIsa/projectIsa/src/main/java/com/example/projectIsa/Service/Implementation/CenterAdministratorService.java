package com.example.projectIsa.Service.Implementation;

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
import com.example.projectIsa.Repository.CenterAdministratorRepository;
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
	
	@Autowired
	public CenterAdministratorService(CenterAdministratorRepository centerAdministratorRepository,
			IEducationService educationService, IAddressService addressService, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		this.centerAdministratorRepository = centerAdministratorRepository;
		this.educationService = educationService;
		this.addressService = addressService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
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
		centerAdmin.setRole(Role.CENTERADMIN);
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

}
