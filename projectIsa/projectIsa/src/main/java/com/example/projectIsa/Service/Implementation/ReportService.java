package com.example.projectIsa.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.ReportDTO;
import com.example.projectIsa.Model.BloodType;
import com.example.projectIsa.Model.MedicalEquipment;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.Report;
import com.example.projectIsa.Repository.MedicalEquipmentRepository;
import com.example.projectIsa.Repository.ReportRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IReportService;

@Service
public class ReportService implements IReportService {

	private final ReportRepository reportRepository;
	private final UserRepository userRepository;
	private final MedicalEquipmentRepository medicalEquipmentRepository;
	
	@Autowired
	public ReportService(ReportRepository reportRepository, UserRepository userRepository,
			MedicalEquipmentRepository medicalEquipmentRepository)
    {
       this.reportRepository = reportRepository;
       this.userRepository = userRepository;
       this.medicalEquipmentRepository = medicalEquipmentRepository;
    }

	@Override
	public boolean addReport(ReportDTO reportDTO) {
		
		RegisteredUser patient = userRepository.findOneUserById(reportDTO.getPatientId());
		Report report = new Report(reportDTO);
		report.setRegUser(patient);
		report.setId((int) (reportRepository.count()) + 1 );
		MedicalEquipment blood = medicalEquipmentRepository.findOneMedicalEquipmentByBloodType(reportDTO.getBloodType());
		blood.setQuantity(blood.getQuantity() + reportDTO.getQuantityTaken());
		MedicalEquipment needles = medicalEquipmentRepository.findOneMedicalEquipmentByBloodType(BloodType.NOTBLOOD);
		needles.setQuantity(needles.getQuantity() - reportDTO.getNeedlesUsed());
		
		patient.setGaveBloodDate(reportDTO.getEndTime());
		if(reportRepository.save(report) != null && medicalEquipmentRepository.save(blood) != null && medicalEquipmentRepository.save(needles) != null
				&& userRepository.save(patient) != null) {
        	return true;
        }        
        else
            return false;
	
	}

	@Override
	public List<Report> getReportsForPatient(Integer patientId) {
		return reportRepository.findAllByPatientId(patientId);
	}
}
