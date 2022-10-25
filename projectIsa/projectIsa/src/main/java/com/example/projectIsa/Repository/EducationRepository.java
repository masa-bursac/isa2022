package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Education;

@Repository
public interface EducationRepository  extends JpaRepository<Education, Integer>{
}
