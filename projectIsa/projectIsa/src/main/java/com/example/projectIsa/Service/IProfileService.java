package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.DTO.UserDTO;

public interface IProfileService {

	UpdateDTO getProfile(String email);
	Boolean update(UpdateDTO userInfo);
	List<UserDTO> getUsers();
}
