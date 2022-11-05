package com.example.projectIsa.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.projectIsa.Model.MedicalEquipment;
import com.example.projectIsa.Repository.MedicalEquipmentRepository;
import com.example.projectIsa.Service.IMedicalEquipmentService;


public class MedicalEquipmentService implements IMedicalEquipmentService{

	private final MedicalEquipmentRepository medicalEquipmentRepository;
	
	@Autowired
	public MedicalEquipmentService(MedicalEquipmentRepository medicalEquipmentRepository)
    {
        this.medicalEquipmentRepository = medicalEquipmentRepository;
    }

	@Override
	public List<MedicalEquipment> getBlood() {
		return medicalEquipmentRepository.findAll();
	}
}
