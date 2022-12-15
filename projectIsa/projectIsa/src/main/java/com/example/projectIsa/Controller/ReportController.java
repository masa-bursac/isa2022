package com.example.projectIsa.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.FreeAppointmentDTO;
import com.example.projectIsa.DTO.ReportDTO;
import com.example.projectIsa.Model.Report;
import com.example.projectIsa.Service.IReportService;


@RestController
@RequestMapping("/report")
public class ReportController {
	
	private final IReportService reportService;
	
	public ReportController(IReportService reportSurvice) {
		this.reportService = reportSurvice;
	}
	 
	@PostMapping(value = "/addReport")
	//@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public ResponseEntity addReport(@RequestBody ReportDTO report) {
        try {
        	return new ResponseEntity(reportService.addReport(report), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
