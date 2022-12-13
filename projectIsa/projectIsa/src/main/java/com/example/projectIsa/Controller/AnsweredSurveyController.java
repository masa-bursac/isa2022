package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.projectIsa.Model.AnsweredSurvey;
import com.example.projectIsa.Service.IAnsweredSurveyService;


@RestController
@RequestMapping("/answeredSurvey")
public class AnsweredSurveyController {


	private final IAnsweredSurveyService answeredSurveyService;
	
	public AnsweredSurveyController(IAnsweredSurveyService answeredSurveyService) {
		this.answeredSurveyService = answeredSurveyService;
	}
	
	@GetMapping("/getAllAnsweredSurvey/{patientId}")
	@PreAuthorize("hasRole('ROLE_CENTERADMIN')")
    public List<AnsweredSurvey> getAllAnsweredSurvey(@PathVariable Integer patientId) {
        return answeredSurveyService.getAnsweredSurvey(patientId);
    }
}
