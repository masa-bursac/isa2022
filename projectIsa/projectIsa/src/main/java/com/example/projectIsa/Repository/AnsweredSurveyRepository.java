package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model. AnsweredSurvey;

@Repository
public interface AnsweredSurveyRepository extends JpaRepository< AnsweredSurvey, Integer>{

}
