package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.CentreDTO;

public interface ICenterService {
	CentreDTO getCenterByAdminId(Integer id);
	Boolean update(CentreDTO centerInfo);
  List<CentersDTO> getAllCenters();
	List<CentersDTO> searchByNameAndAddress(String search);
	CentersDTO registerCenter(CentersDTO center);
}
