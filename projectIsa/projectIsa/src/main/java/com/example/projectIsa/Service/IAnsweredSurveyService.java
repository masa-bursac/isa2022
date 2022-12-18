package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.AnsweredSurveyDTO;
import com.example.projectIsa.Model.AnsweredSurvey;

public interface IAnsweredSurveyService {

	List<AnsweredSurveyDTO> getAnsweredSurvey(Integer patientId);

}
