package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.UpdateDTO;

public interface IProfileService {

	UpdateDTO getProfile(String email);
}
