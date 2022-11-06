package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.CentersDTO;

public interface ICenterService {

	List<CentersDTO> getAllCenters();
	List<CentersDTO> searchByNameAndAddress(String search);
	CentersDTO registerCenter(CentersDTO center);
}
