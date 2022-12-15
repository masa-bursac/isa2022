package com.example.projectIsa.Service;

import org.springframework.util.MultiValueMap;

import com.example.projectIsa.DTO.ReportDTO;
import com.example.projectIsa.Model.Report;

public interface IReportService {

	boolean addReport(ReportDTO report);
}
