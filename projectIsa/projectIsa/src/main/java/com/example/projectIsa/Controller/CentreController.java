package com.example.projectIsa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.Service.ICenterService;

@RestController
@RequestMapping("/center")
public class CentreController {
	
	private final ICenterService centreService;
	
	public CentreController(ICenterService centreService) {
		this.centreService = centreService;
	}
	
	@GetMapping("/getCentreByAdminId/{id}")
    public CentreDTO getCentreByAdminId(@PathVariable Integer id){
			
        return centreService.getCenterByAdminId(id);
	
    }

}
