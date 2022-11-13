package com.example.projectIsa.Service.Implementation;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CenterAdminPasswordDTO;
import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.Gender;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Repository.EducationRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IProfileService;

@Service
public class ProfileService implements IProfileService{

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final EducationRepository educationRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ProfileService(UserRepository userRepository, AddressRepository addressRepository,
			EducationRepository educationRepository,PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.educationRepository = educationRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public UpdateDTO getProfile(String email) {
		UpdateDTO getUser = new UpdateDTO();
		User user = userRepository.findOneByEmail(email);
		CenterAdministrator admin = userRepository.findOneById(user.getId());
		Address address = addressRepository.findOneById(user.getId());
		Education education = educationRepository.findOneById(user.getId());
		getUser.setId(user.getId());
		getUser.setName(user.getName());
		getUser.setSurname(user.getSurname());
		getUser.setEmail(user.getEmail());
		getUser.setPhoneNumber(user.getPhoneNumber());
		getUser.setJmbg(user.getJmbg());
		getUser.setGender(user.getGender().toString());
		getUser.setStreet(address.getStreet());
		getUser.setHouseNumber(address.getHouseNumber());
		getUser.setCity(address.getCity());
		getUser.setState(address.getState());
		getUser.setPostcode(address.getPostcode());
		getUser.setEducation(education.getEducation());
		getUser.setProfession(education.getProfession());
		if(!(admin == null)) {
			getUser.setCenterId(admin.getCenter().getId());
		}
		
		return getUser;

	}
	
	@Override
	public Boolean update(UpdateDTO userInfo) {
		User userForUpdating = userRepository.findOneByEmail(userInfo.getEmail());
		
		userForUpdating.setName(userInfo.getName());
		userForUpdating.setSurname(userInfo.getSurname());
		userForUpdating.setEmail(userInfo.getEmail());
		userForUpdating.setPhoneNumber(userInfo.getPhoneNumber());
		userForUpdating.setJmbg(userInfo.getJmbg());
		
		if(userInfo.getGender().toLowerCase().equals(Gender.MALE.toString().toLowerCase(Locale.ROOT)))
			userForUpdating.setGender(Gender.MALE);
        else if(userInfo.getGender().toLowerCase().equals(Gender.FEMALE.toString().toLowerCase(Locale.ROOT)))
        	userForUpdating.setGender(Gender.FEMALE);
        else if(userInfo.getGender().toLowerCase().equals(Gender.NONBINARY.toString().toLowerCase(Locale.ROOT)))
        	userForUpdating.setGender(Gender.NONBINARY);
        else
        	userForUpdating.setGender(Gender.OTHER);
		
		Address address = addressRepository.findOneById(userForUpdating.getId());
		address.setStreet(userInfo.getStreet());
		address.setHouseNumber(userInfo.getHouseNumber());
		address.setCity(userInfo.getCity());
		address.setState(userInfo.getState());
		address.setPostcode(userInfo.getPostcode());
		
		Education education = educationRepository.findOneById(userForUpdating.getId());
		education.setEducation(userInfo.getEducation());
		education.setProfession(userInfo.getProfession());
		
		
        if (educationRepository.save(education) != null && addressRepository.save(address) != null && userRepository.save(userForUpdating) != null) {
        	return true;
        }        
        else
            return false;
        
	}

	@Override
	public Boolean changeCenterAdminPassword(CenterAdminPasswordDTO admin) {
		CenterAdministrator administrator = userRepository.findOneById(admin.getId());
		if(administrator != null) {
			administrator.setPassword(passwordEncoder.encode(admin.getPassword()));
			if (userRepository.save(administrator) != null) {
				return true;
	        }        
	        else
	            return false;
		}
		else {
			return false;
		}
	}
	
}
