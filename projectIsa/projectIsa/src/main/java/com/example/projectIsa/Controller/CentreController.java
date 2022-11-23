package com.example.projectIsa.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CentreDTO;
import com.example.projectIsa.DTO.UpdateDTO;
import com.example.projectIsa.Service.ICenterService;

@RestController
@RequestMapping("/center")
public class CentreController {
	
	private final ICenterService centreService;
	
	public CentreController(ICenterService centreService) {
		this.centreService = centreService;
	}
	
	@GetMapping("/getCentreByAdminId/{id}")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public CentreDTO getCentreByAdminId(@PathVariable Integer id){
			
        return centreService.getCenterByAdminId(id);
	
    }
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
	public Boolean edit(@RequestBody CentreDTO centerInfo) {

    	return centreService.update(centerInfo);	      
	}

}
