package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.Config.EmailContext;
import com.example.projectIsa.DTO.ComplaintAnswerDTO;
import com.example.projectIsa.Model.Complaint;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.ComplaintRepository;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IEmailService;
import org.thymeleaf.context.Context;

@Service
public class EmailService implements IEmailService {


	private final EmailContext emailContext;
	private final ComplaintRepository complaintRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public EmailService(EmailContext emailContext, ComplaintRepository complaintRepository, UserRepository userRepository) {
		this.emailContext = emailContext;
		this.complaintRepository = complaintRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Boolean answerComplaint(ComplaintAnswerDTO complaintAnswerDTO) {
		
		Complaint complaint = complaintRepository.findById(complaintAnswerDTO.getId()).get();
		User complaintWriter = userRepository.findById(complaint.getRegUser().getId()).get();		
		User adminWhoAnswers = userRepository.findById(complaintAnswerDTO.getAdminAnswerId()).get();
        
        String title = "Odgovor na Vašu žalbu";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", complaintWriter.getName(), complaintWriter.getSurname()));
        context.setVariable("answer", String.format("%s", complaintAnswerDTO.getAnswer()));
        context.setVariable("admin", String.format("%s %s", adminWhoAnswers.getName(), adminWhoAnswers.getSurname()));

        emailContext.send("firma4validation@gmail.com", title, "answerComplaint", context);
        return true;
	}

}
