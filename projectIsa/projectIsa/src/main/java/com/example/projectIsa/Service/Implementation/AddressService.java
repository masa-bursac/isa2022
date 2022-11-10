package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Service.IAddressService;

@Service
public class AddressService implements IAddressService {

	private final AddressRepository addressRepository;
	
	@Autowired
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address addAddress(CenterAdministratorDTO adminDTO, CenterAdministrator admin) {
		Address address = new Address();
		address.setId((int) (addressRepository.count()+1));
		address.setLatitude(0);
		address.setLongitude(0);
		address.setCity(adminDTO.getCity());
		address.setHouseNumber(adminDTO.getHouseNumber());
		address.setPostcode(adminDTO.getPostcode());
		address.setState(adminDTO.getState());
		address.setStreet(adminDTO.getStreet());
		address.setUser(admin);
		admin.setAddress(address);
		address.setUser(admin);
		return addressRepository.save(address);
	}

}
