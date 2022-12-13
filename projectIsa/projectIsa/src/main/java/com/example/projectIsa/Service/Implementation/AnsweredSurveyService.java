package com.example.projectIsa.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.Model.AnsweredSurvey;
import com.example.projectIsa.Repository.AddressRepository;
import com.example.projectIsa.Repository.AnsweredSurveyRepository;
import com.example.projectIsa.Service.IAnsweredSurveyService;

@Service
public class AnsweredSurveyService implements IAnsweredSurveyService {
	
	private final AnsweredSurveyRepository answeredSurveyRepository;
	
	@Autowired
	public AnsweredSurveyService(AnsweredSurveyRepository answeredSurveyRepository) {
		this.answeredSurveyRepository = answeredSurveyRepository;
	}

	@Override
	public List<AnsweredSurvey> getAnsweredSurvey(Integer patientId) {
		return answeredSurveyRepository.findByRegUserId(patientId);
	}

}
