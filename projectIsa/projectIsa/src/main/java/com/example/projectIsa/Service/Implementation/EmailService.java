package com.example.projectIsa.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.Config.EmailContext;
import com.example.projectIsa.Model.User;
import com.example.projectIsa.Repository.UserRepository;
import com.example.projectIsa.Service.IEmailService;
import org.thymeleaf.context.Context;

@Service
public class EmailService implements IEmailService {


	private final EmailContext emailContext;
	private final UserRepository userRepository;
	
	@Autowired
	public EmailService(EmailContext emailContext, UserRepository userRepository) {
		this.emailContext = emailContext;
		this.userRepository = userRepository;
	}

	@Override
	public Boolean scheduleAppointment(String name, String surname) {
		String title = "Zakazivanje termina";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", name, surname));

        emailContext.send("firma4validation@gmail.com", title, "scheduleAppointment", context);
        return true;
	}

}
