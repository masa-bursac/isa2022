package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;

public interface ICenterAdministratorService {

	boolean addAdmin(CenterAdministratorDTO adminDTO, Center centerId);

	List<CenterAdministrator> getAllCentreAdminByCenterId(Integer id);
}
