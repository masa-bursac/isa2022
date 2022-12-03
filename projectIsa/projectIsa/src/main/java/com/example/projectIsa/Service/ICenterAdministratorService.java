package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.SystemAdminstrator;

public interface ICenterAdministratorService {

	boolean addAdmin(CenterAdministratorDTO adminDTO, Center centerId);

	List<CenterAdministrator> getAllCentreAdminByCenterId(Integer id);

	SystemAdminstrator registerSystemAdmin(CenterAdministratorDTO centerAdministratorDTO);
}
