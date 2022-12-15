package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.ReportDTO;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.Report;
import com.example.projectIsa.Repository.ReportRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IReportService;

@Service
public class ReportService implements IReportService {

	private final ReportRepository reportRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public ReportService(ReportRepository reportRepository, UserRepository userRepository)
    {
       this.reportRepository = reportRepository;
       this.userRepository = userRepository;
    }

	@Override
	public boolean addReport(ReportDTO reportDTO) {
		
		RegisteredUser patient = userRepository.findOneUserById(reportDTO.getPatientId());
		Report report = new Report(reportDTO);
		report.setRegUser(patient);
		report.setId((int) (reportRepository.count()) + 1 );
		if(reportRepository.save(report) != null) {
        	return true;
        }        
        else
            return false;
	
	}
}
