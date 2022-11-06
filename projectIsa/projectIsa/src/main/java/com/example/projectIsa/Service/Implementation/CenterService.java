package com.example.projectIsa.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Repository.CenterAddressRepository;
import com.example.projectIsa.Repository.CenterRepository;
import com.example.projectIsa.Service.ICenterAdministratorService;
import com.example.projectIsa.Service.ICenterService;

@Service
public class CenterService implements ICenterService{
	
	private final CenterRepository centerRepository;
	private final CenterAddressRepository centerAddressRepository;
	private final ICenterAdministratorService centerAdministratorService;

	
	@Autowired
    public CenterService(CenterRepository centerRepository, CenterAddressRepository centerAddressRepository,
    		ICenterAdministratorService centerAdministratorService){
        this.centerRepository = centerRepository;
        this.centerAddressRepository = centerAddressRepository;
        this.centerAdministratorService = centerAdministratorService;
    }

	@Override
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
        	System.out.println("nije prazna lista sa adminima");
			for(CenterAdministratorDTO adminDTO: centerDTO.getCenterAdmins()) {
				centerAdministratorService.addAdmin(adminDTO, center);
			}
		}
		return centerDTO;
	}

}
