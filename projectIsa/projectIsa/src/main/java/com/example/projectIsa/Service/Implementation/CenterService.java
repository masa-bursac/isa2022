package com.example.projectIsa.Service.Implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Repository.CenterAddressRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Service.ICenterAdministratorService;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.Service.ICenterService;

@Service
public class CenterService implements ICenterService{


	private final CenterRepository centerRepository;
	private final UserRepository userRepository;
	private final CenterAddressRepository centerAddressRepository;
	private final ICenterAdministratorService centerAdministratorService;

	
	@Autowired
    public CenterService(CenterRepository centerRepository, UserRepository userRepository, CenterAddressRepository centerAddressRepository,
    		ICenterAdministratorService centerAdministratorService){
        this.centerRepository = centerRepository;
        this.userRepository = userRepository;
        this.centerAddressRepository = centerAddressRepository;
        this.centerAdministratorService = centerAdministratorService;
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
		/*for(CenterAdministrator admin: returnCentre.getStaff()) {
			if(admin.getId().equals(user.getId())) {
				returnCentre.getStaff().remove(admin);
			}
		}*/
		returnCentre.getStaff().removeIf((CenterAdministrator a) -> a.getId() == user.getId());
	
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

	public List<CentersDTO> getAllCenters() {
		List<CentersDTO> allCenters = new ArrayList<>();
		List<Center> centers = centerRepository.findAll();
		
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
		return allCenters;
	}

	@Override
	public List<CentersDTO> searchByNameAndAddress(String search) {
		List<CentersDTO> allCenters = new ArrayList<>();
		List<Center> centers = centerRepository.findAll();
		
		CentersDTO centersDTO = new CentersDTO();

		for(int i = 0; i < centers.size(); i++) {
			CenterAddress address = centerAddressRepository.findOneById(centers.get(i).getId());
			if(centers.get(i).getName().toLowerCase().contains(search.toLowerCase()) || 
					address.getCity().toLowerCase().contains(search.toLowerCase()) || 
					address.getStreet().toLowerCase().contains(search.toLowerCase())) {
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
		
		return allCenters;
	}

	@Override
	public CentersDTO registerCenter(CentersDTO centerDTO) {
		Center center = new Center(centerDTO);
		center.setId((int)centerRepository.count()+1);
		Integer addressId = (int) centerAddressRepository.count()+1;
		CenterAddress address = new CenterAddress(addressId, 0, 0, centerDTO.getStreet(),centerDTO.getHouseNumber(),
				centerDTO.getCity(),centerDTO.getState(), centerDTO.getPostcode(), center);
		center.setCenterAddress(address);
		address.setCenter(center);
		address = centerAddressRepository.save(address);
		center.setCenterAddress(address);
		center = centerRepository.save(center);
		if(!centerDTO.getCenterAdmins().isEmpty()) {
			for(CenterAdministratorDTO adminDTO: centerDTO.getCenterAdmins()) {
				centerAdministratorService.addAdmin(adminDTO, center);
			}
		}
		return centerDTO;
	}

}
