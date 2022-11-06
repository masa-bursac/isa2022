package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CenterAdministratorDTO;
import com.example.projectIsa.Model.Center;

public interface ICenterAdministratorService {

	boolean addAdmin(CenterAdministratorDTO adminDTO, Center centerId);
}
