package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Address;
import com.example.projectIsa.Model.CenterAdministrator;

public interface IAddressService {

	Address addAddress(CenterAdministratorDTO adminDTO, CenterAdministrator admin);

}
