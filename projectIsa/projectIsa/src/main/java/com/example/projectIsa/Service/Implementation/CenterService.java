package com.example.projectIsa.Service.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.ICenterService;

@Service
public class CenterService implements ICenterService{

	private final CenterRepository centerRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public CenterService(CenterRepository centerRepository, UserRepository userRepository)
    {
        this.centerRepository = centerRepository;
        this.userRepository = userRepository;
    }

	@Override
	public CentreDTO getCenterByAdminId(Integer id) {
		
		CentreDTO returnCentre = new CentreDTO();
		CenterAdministrator user = userRepository.findOneById(id);
		Center center = centerRepository.findOneById(user.getCenter().getId());
		
		returnCentre.setId(center.getId());
		returnCentre.setName(center.getName());
		returnCentre.setCenterAddress(center.getCenterAddress());
		returnCentre.setDescription(center.getDescription());
		returnCentre.setRating(center.getRating());
		returnCentre.setAppointments(center.getAppointments());
		for(CenterAdministrator admin: center.getStaff()) {
			admin.setCenter(null);
		}
		
		returnCentre.setStaff(center.getStaff());
		
		return returnCentre;
	}


}
