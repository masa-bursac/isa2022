package com.example.projectIsa.Service;

import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;

public interface IEducationService {

	Education addEducation(String education, String profession, CenterAdministrator centerAdmin);
}
