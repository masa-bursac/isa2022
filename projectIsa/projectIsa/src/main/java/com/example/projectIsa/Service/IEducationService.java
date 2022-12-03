package com.example.projectIsa.Service;

import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.Model.Education;
import com.example.projectIsa.Model.SystemAdminstrator;

public interface IEducationService {

	Education addEducation(String education, String profession, CenterAdministrator centerAdmin);

	Education addEducation(String education, String profession, SystemAdminstrator systemAdmin);
}
