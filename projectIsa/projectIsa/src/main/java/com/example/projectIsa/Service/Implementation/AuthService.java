package com.example.projectIsa.Service.Implementation;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.projectIsa.DTO.AuthDTO;
import com.example.projectIsa.DTO.RegistrationDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.Gender;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.Role;
import com.example.projectIsa.Model.SystemAdminstrator;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Repository.CenterAdministratorRepository;
import com.example.projectIsa.Repository.EducationRepository;
import com.example.projectIsa.Repository.SystemAdministratorRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IAuthService;

@Service
public class AuthService implements IAuthService{
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final EducationRepository educationRepository;
	private final EmailService emailService;
	private final PasswordEncoder passwordEncoder;
	private final CenterAdministratorRepository centerAdministratorRepository;
	private final SystemAdministratorRepository systemAdministratorRepository;
	
	@Autowired
	public AuthService(UserRepository userRepository, AddressRepository addressRepository,
			EducationRepository educationRepository, EmailService emailService, PasswordEncoder passwordEncoder, CenterAdministratorRepository centerAdministratorRepository,
			SystemAdministratorRepository systemAdministratorRepository)
    {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.educationRepository = educationRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.centerAdministratorRepository = centerAdministratorRepository;
        this.systemAdministratorRepository = systemAdministratorRepository;
    }
	
	@Override
	public Boolean registration(RegistrationDTO registrationDTO) {
		RegisteredUser regUser = new RegisteredUser();
		regUser.setName(registrationDTO.getName());
		regUser.setSurname(registrationDTO.getSurname());
		regUser.setEmail(registrationDTO.getEmail());
		regUser.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		regUser.setPhoneNumber(registrationDTO.getPhoneNumber());
		regUser.setJmbg(registrationDTO.getJmbg());
		regUser.setRole(Role.ROLE_REGISTERED);
		regUser.setActive(false);
		
		if(registrationDTO.getGender().toLowerCase().equals(Gender.MALE.toString().toLowerCase(Locale.ROOT)))
			regUser.setGender(Gender.MALE);
        else if(registrationDTO.getGender().toLowerCase().equals(Gender.FEMALE.toString().toLowerCase(Locale.ROOT)))
        	regUser.setGender(Gender.FEMALE);
        else if(registrationDTO.getGender().toLowerCase().equals(Gender.NONBINARY.toString().toLowerCase(Locale.ROOT)))
        	regUser.setGender(Gender.NONBINARY);
        else
        	regUser.setGender(Gender.OTHER);
		
		Address address = new Address();
		address.setId(regUser.getId());
		address.setStreet(registrationDTO.getStreet());
		address.setHouseNumber(registrationDTO.getHouseNumber());
		address.setCity(registrationDTO.getCity());
		address.setState(registrationDTO.getState());
		address.setPostcode(registrationDTO.getPostcode());
		
		Education education = new Education();
		education.setId(regUser.getId());
		education.setEducation(registrationDTO.getEducation());
		education.setProfession(registrationDTO.getProfession());
		
		regUser.setAddress(address);
		regUser.setEducation(education);
		
		emailService.sendEmailRegistration(regUser);
		
        if (educationRepository.save(education) != null && addressRepository.save(address) != null && userRepository.save(regUser) != null) {
        	return true;
        }        
        else
            return false;
	}

	@Override
	public Boolean HasToChangePass(@Valid AuthDTO loginRequest) {
		User user = userRepository.findOneByEmail(loginRequest.getEmail());
		Role role = user.getRole();
	
		if(role.equals(Role.ROLE_CENTERADMIN)) {
			if(centerAdministratorRepository.findById(user.getId()).get().isHasToChangePass()) {
				return true;
			}
		}
		else if(role.equals(Role.ROLE_SYSTEMADMIN)) {
			if(systemAdministratorRepository.findById(user.getId()).get().getHasToChangePass()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean continueRegistration(String email) {
		User user = userRepository.findOneByEmail(email);
		user.setActive(true);
        userRepository.save(user);
        return true;
	}
}
