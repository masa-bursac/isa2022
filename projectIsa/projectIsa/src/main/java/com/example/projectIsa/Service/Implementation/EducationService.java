package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.SystemAdminstrator;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.EducationRepository;
import com.example.projectIsa.Service.IEducationService;

@Service
public class EducationService implements IEducationService {

	private final EducationRepository educationRepository;
	
	@Autowired
	public EducationService(EducationRepository educationRepository) {
		this.educationRepository = educationRepository;
	}

	@Override
	public Education addEducation(String education, String profession, CenterAdministrator centerAdmin) {
		Education newEducation = new Education(education, profession);
		newEducation.setId((int) educationRepository.count()+1);
		centerAdmin.setEducation(newEducation);
		newEducation.setUser(centerAdmin);
		educationRepository.save(newEducation);

		return newEducation;
	}

	@Override
	public Education addEducation(String education, String profession, SystemAdminstrator systemAdmin) {
		Education newEducation = new Education(education, profession);
		newEducation.setId((int) educationRepository.count()+1);
		systemAdmin.setEducation(newEducation);
		newEducation.setUser(systemAdmin);
		educationRepository.save(newEducation);

		return newEducation;
	}

}
