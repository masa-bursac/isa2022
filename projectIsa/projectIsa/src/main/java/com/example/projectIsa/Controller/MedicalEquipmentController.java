package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.Model.MedicalEquipment;
import com.example.projectIsa.Service.IMedicalEquipmentService;

@RestController
@RequestMapping("/medicalEquipment")
public class MedicalEquipmentController {
	
	private final IMedicalEquipmentService medicalEquipmentService;
	
	public MedicalEquipmentController(IMedicalEquipmentService medicalEquipmentService) {
		this.medicalEquipmentService = medicalEquipmentService;
	}
	
	@GetMapping("/getBlood")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public List<MedicalEquipment> getBlood(){
        return medicalEquipmentService.getBlood();
    }
	
}
