package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CenterAdminPasswordDTO;
import com.example.projectIsa.DTO.DonorsDTO;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.DTO.UserDTO;

public interface IProfileService {

	UpdateDTO getProfile(String email);
	Boolean update(UpdateDTO userInfo);
	Boolean changeCenterAdminPassword(CenterAdminPasswordDTO admin);
	List<UserDTO> getUsers();
	Boolean changeSystemAdminPassword(CenterAdminPasswordDTO admin);
	List<DonorsDTO> getDonors();
}
