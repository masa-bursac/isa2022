package com.example.projectIsa.Service.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Repository.CenterAddressRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.ICenterService;

@Service
public class CenterService implements ICenterService{

	private final CenterRepository centerRepository;
	private final UserRepository userRepository;
	private final CenterAddressRepository centerAddressRepository;
	
	@Autowired
	public CenterService(CenterRepository centerRepository, UserRepository userRepository, 
			CenterAddressRepository centerAddressRepository)
    {
        this.centerRepository = centerRepository;
        this.userRepository = userRepository;
        this.centerAddressRepository = centerAddressRepository;
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
		for(CenterAdministrator admin: returnCentre.getStaff()) {
			if(admin.getId().equals(user.getId())) {
				returnCentre.getStaff().remove(admin);
			}
		}
		
		return returnCentre;
	}

	@Override
	public Boolean update(CentreDTO centerInfo) {
		Center centerForUpdating = centerRepository.findOneById(centerInfo.getId());
		
		centerForUpdating.setName(centerInfo.getName());
		centerForUpdating.setDescription(centerInfo.getDescription());
		centerForUpdating.setRating(centerInfo.getRating());
		
		CenterAddress address = centerAddressRepository.findOneById(centerForUpdating.getId());
		address.setStreet(centerInfo.getCenterAddress().getStreet());
		address.setHouseNumber(centerInfo.getCenterAddress().getHouseNumber());
		address.setCity(centerInfo.getCenterAddress().getCity());
		address.setState(centerInfo.getCenterAddress().getState());
		address.setPostcode(centerInfo.getCenterAddress().getPostcode());
		
		if (centerAddressRepository.save(address) != null && centerRepository.save(centerForUpdating) != null) {
        	return true;
        }        
        else
            return false;
	}


}
