package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.MedicalEquipment;

@Repository
public interface MedicalEquipmentRepository extends JpaRepository<MedicalEquipment, Integer>{

}
