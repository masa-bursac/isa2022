package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Model.Center;

public interface ICenterService {
	CentreDTO getCenterByAdminId(Integer id);
}
