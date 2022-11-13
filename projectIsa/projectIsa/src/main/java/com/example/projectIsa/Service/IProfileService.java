package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CenterAdminPasswordDTO;
import com.example.projectIsa.DTO.UpdateDTO;

public interface IProfileService {

	UpdateDTO getProfile(String email);
	Boolean update(UpdateDTO userInfo);
	Boolean changeCenterAdminPassword(CenterAdminPasswordDTO admin);
}
