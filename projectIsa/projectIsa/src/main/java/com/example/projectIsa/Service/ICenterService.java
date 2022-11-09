package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CentreDTO;

public interface ICenterService {
	CentreDTO getCenterByAdminId(Integer id);
	Boolean update(CentreDTO centerInfo);
}
