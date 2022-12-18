package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.ComplaintAnswerDTO;
import com.example.projectIsa.Model.RegisteredUser;
import com.example.projectIsa.Model.User;

public interface IEmailService {

	Boolean answerComplaint(ComplaintAnswerDTO complaintAnswerDTO);

	Boolean scheduleAppointment(String name, String surname);

	void sendEmailRegistration(RegisteredUser user);
}
