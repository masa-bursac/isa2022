package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Service.ICenterAdministratorService;
import com.example.projectIsa.Service.ICenterService;

@RestController
@RequestMapping("/centerAdmin")
public class CenterAdministratorController {
	private final ICenterAdministratorService centerAdminService;
	
	public CenterAdministratorController(ICenterAdministratorService centerAdminService) {
		this.centerAdminService = centerAdminService;
	}
	
	@GetMapping("/getAllCentreAdminByCenterId/{id}")
    public List<CenterAdministrator> getAllCentreAdminByCenterId(@PathVariable Integer id){
			
        return centerAdminService.getAllCentreAdminByCenterId(id);
	
    }

}
