package com.example.projectIsa.Service;

import javax.validation.Valid;

import com.example.projectIsa.DTO.AuthDTO;
import com.example.projectIsa.DTO.RegistrationDTO;

public interface IAuthService {

	Boolean registration(RegistrationDTO registrationDTO);

	Boolean HasToChangePass(@Valid AuthDTO loginRequest);

	boolean continueRegistration(String email);

	Integer getPenals(Integer userId);

}
