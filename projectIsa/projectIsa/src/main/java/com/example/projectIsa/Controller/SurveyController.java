package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.AnswerDTO;
import com.example.projectIsa.DTO.SurveyDTO;
import com.example.projectIsa.Model.AnsweredSurvey;
import com.example.projectIsa.Service.ISurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	private final ISurveyService surveyService;
	
	public SurveyController(ISurveyService surveyService) {
		this.surveyService = surveyService;
	}
	 
	@GetMapping("/getQuestions")
	public List<SurveyDTO> getAllSurveys() {
		return surveyService.getAllSurveys();
	}
	
	@PostMapping("/addAnswer")
	public Boolean addInterest(@RequestBody List<AnswerDTO> answerDTO) {
		return surveyService.post(answerDTO);
    }
}
