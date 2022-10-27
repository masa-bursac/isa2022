package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer>{
	
}
