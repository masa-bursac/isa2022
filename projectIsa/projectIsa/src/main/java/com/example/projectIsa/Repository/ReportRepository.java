package com.example.projectIsa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	List<Report> findAllByPatientId(Integer patientId);
}
