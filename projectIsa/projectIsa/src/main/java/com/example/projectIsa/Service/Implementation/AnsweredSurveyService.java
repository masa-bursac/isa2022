package com.example.projectIsa.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.AnsweredSurveyDTO;
import com.example.projectIsa.Model.AnsweredSurvey;
import com.example.projectIsa.Model.Survey;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Repository.AnsweredSurveyRepository;
import com.example.projectIsa.Repository.SurveyRepository;
import com.example.projectIsa.Service.IAnsweredSurveyService;

@Service
public class AnsweredSurveyService implements IAnsweredSurveyService {
	
	private final AnsweredSurveyRepository answeredSurveyRepository;
	private final SurveyRepository surveyRepository;
	
	@Autowired
	public AnsweredSurveyService(AnsweredSurveyRepository answeredSurveyRepository, SurveyRepository surveyRepository) {
		this.answeredSurveyRepository = answeredSurveyRepository;
		this.surveyRepository = surveyRepository;
		
	}

	@Override
	public List<AnsweredSurveyDTO> getAnsweredSurvey(Integer patientId) {
		List<AnsweredSurveyDTO> returnAnswers = new ArrayList<AnsweredSurveyDTO>();
		for(AnsweredSurvey answers: answeredSurveyRepository.findByRegUserId(patientId)) {
			AnsweredSurveyDTO returnAnswer = new AnsweredSurveyDTO(answers.isAnswers(), answers.getSurveyId(), null);
			for(Survey survey: surveyRepository.findAll()) {
				if(survey.getId().equals(answers.getSurveyId())) {
					returnAnswer.setQuestion(survey.getQuestion());
				}
			}
			returnAnswers.add(returnAnswer);
		}
		return returnAnswers;
	}

}
