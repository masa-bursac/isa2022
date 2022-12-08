package com.example.projectIsa.Service;

import com.example.projectIsa.DTO.ComplaintAnswerDTO;

public interface IEmailService {

	Boolean answerComplaint(ComplaintAnswerDTO complaintAnswerDTO);

	Boolean scheduleAppointment(String name, String surname);
}
