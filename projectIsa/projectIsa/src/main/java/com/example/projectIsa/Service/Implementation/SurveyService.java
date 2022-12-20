package com.example.projectIsa.Service.Implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.AnswerDTO;
import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.DTO.SurveyDTO;
import com.example.projectIsa.Model.AnsweredSurvey;
import com.example.projectIsa.Model.Center;
import com.example.projectIsa.Model.CenterAddress;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.Survey;
import com.example.projectIsa.Repository.AnsweredSurveyRepository;
import com.example.projectIsa.Repository.SurveyRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.ISurveyService;

@Service
public class SurveyService implements ISurveyService {

	private final SurveyRepository surveyRepository;
	private final AnsweredSurveyRepository ansRepository;
	private final UserRepository userRepository;
	
	@Autowired
    public SurveyService(SurveyRepository surveyRepository, AnsweredSurveyRepository ansRepository,
    		UserRepository userRepository){
        this.surveyRepository = surveyRepository;
        this.ansRepository = ansRepository;
        this.userRepository = userRepository;
    }
	
	@Override
	public List<SurveyDTO> getAllSurveys() {
		List<SurveyDTO> allSurveys = new ArrayList<>();
		List<Survey> surveys = surveyRepository.findAll();
		
		SurveyDTO surveysDTO = new SurveyDTO();
		
		for(int i = 0; i < surveys.size(); i++) {
			surveysDTO = new SurveyDTO();
			surveysDTO.setId(surveys.get(i).getId());
			surveysDTO.setQuestion(surveys.get(i).getQuestion());
			allSurveys.add(surveysDTO);
		}
		return allSurveys;
	}

	@Override
	public Boolean post(List<AnswerDTO> answerDTO) {
		AnsweredSurvey answers = new AnsweredSurvey();
		for(int i = 0; i < answerDTO.size(); i++) {
			answers = new AnsweredSurvey();
			//answers.setId(answerDTO.get(i).getId());
			answers.setRegUserId(answerDTO.get(i).getRegUserId());
			answers.setSurveyId(answerDTO.get(i).getId());
			answers.setAnswers(answerDTO.get(i).getAnswers());
			ansRepository.save(answers);
			
			RegisteredUser regUser = userRepository.findOneUserById(answerDTO.get(i).getRegUserId());
			regUser.setTookSurvey((LocalDateTime.now()));
		}
		
		return true;
	}

}
