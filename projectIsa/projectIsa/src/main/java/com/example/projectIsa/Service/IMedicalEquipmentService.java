package com.example.projectIsa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projectIsa.Model.MedicalEquipment;

@Service
public interface IMedicalEquipmentService {

	List<MedicalEquipment> getBlood();
}
