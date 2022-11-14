package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.AnswerDTO;
import com.example.projectIsa.DTO.SurveyDTO;

public interface ISurveyService {
	List<SurveyDTO> getAllSurveys();
	Boolean post(List<AnswerDTO> answerDTO);
}
