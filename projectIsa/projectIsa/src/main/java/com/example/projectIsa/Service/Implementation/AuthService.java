package com.example.projectIsa.Service.Implementation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.RegistrationDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.Gender;
import com.example.projectIsa.Model.Role;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Repository.EducationRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IAuthService;

@Service
public class AuthService implements IAuthService{
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final EducationRepository educationRepository;
	
	@Autowired
	public AuthService(UserRepository userRepository, AddressRepository addressRepository, EducationRepository educationRepository)
    {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.educationRepository = educationRepository;
    }
	
	@Override
	public Boolean registration(RegistrationDTO registrationDTO) {
		User userForUpdating = userRepository.findOneByEmail(registrationDTO.getEmail());
		
		userForUpdating.setName(registrationDTO.getName());
		userForUpdating.setSurname(registrationDTO.getSurname());
		userForUpdating.setEmail(registrationDTO.getEmail());
		userForUpdating.setPhoneNumber(registrationDTO.getPhoneNumber());
		userForUpdating.setJmbg(registrationDTO.getJmbg());
		
		if(registrationDTO.getGender().toLowerCase().equals(Gender.MALE.toString().toLowerCase(Locale.ROOT)))
			userForUpdating.setGender(Gender.MALE);
        else if(registrationDTO.getGender().toLowerCase().equals(Gender.FEMALE.toString().toLowerCase(Locale.ROOT)))
        	userForUpdating.setGender(Gender.FEMALE);
        else if(registrationDTO.getGender().toLowerCase().equals(Gender.NONBINARY.toString().toLowerCase(Locale.ROOT)))
        	userForUpdating.setGender(Gender.NONBINARY);
        else
        	userForUpdating.setGender(Gender.OTHER);
		
		Address address = addressRepository.findOneById(userForUpdating.getId());
		address.setStreet(registrationDTO.getStreet());
		address.setHouseNumber(registrationDTO.getHouseNumber());
		address.setCity(registrationDTO.getCity());
		address.setState(registrationDTO.getState());
		address.setPostcode(registrationDTO.getPostcode());
		
		Education education = educationRepository.findOneById(userForUpdating.getId());
		education.setEducation(registrationDTO.getEducation());
		education.setProfession(registrationDTO.getProfession());
		
		
        if (educationRepository.save(education) != null && addressRepository.save(address) != null && userRepository.save(userForUpdating) != null) {
        	return true;
        }        
        else
            return false;
	}
}
