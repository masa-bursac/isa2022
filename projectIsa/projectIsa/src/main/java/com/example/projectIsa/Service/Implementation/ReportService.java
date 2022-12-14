package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.Model.Report;
import com.example.projectIsa.Repository.ReportRepository;
import com.example.projectIsa.Service.IReportService;

@Service
public class ReportService implements IReportService {

	private final ReportRepository reportRepository;
	
	@Autowired
	public ReportService(ReportRepository reportRepository)
    {
       this.reportRepository = reportRepository;
    }

	@Override
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		return null;
	}
}
