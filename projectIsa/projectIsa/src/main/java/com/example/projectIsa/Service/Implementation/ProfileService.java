package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.Education;
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
	
	@Autowired
	public ProfileService(UserRepository userRepository, AddressRepository addressRepository, EducationRepository educationRepository)
    {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.educationRepository = educationRepository;
    }
	
	@Override
	public UpdateDTO getProfile(String email) {
		UpdateDTO getUser = new UpdateDTO();
		User user = userRepository.findOneByEmail(email);
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
		
		return getUser;

	}
}
