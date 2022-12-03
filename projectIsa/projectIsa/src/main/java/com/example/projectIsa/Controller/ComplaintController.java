package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.DTO.CenterAdminPasswordDTO;
import com.example.projectIsa.DTO.ComplaintAnswerDTO;
import com.example.projectIsa.DTO.ComplaintDTO;
import com.example.projectIsa.Service.IComplaintService;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

	private final IComplaintService complaintService;
	
	public ComplaintController(IComplaintService complaintService) {
		this.complaintService = complaintService;
	}
	@GetMapping("/getComplaints")
	@PreAuthorize("hasRole('ROLE_SYSTEMADMIN')")
    public ResponseEntity<List<ComplaintDTO>> getComplaints() {
        return new ResponseEntity<List<ComplaintDTO>>(complaintService.getAllComplaints(), HttpStatus.OK);
    }
	
	@PutMapping("/sendAnswer")
	@PreAuthorize("hasRole('ROLE_SYSTEMADMIN')")
	public ResponseEntity<Boolean> sendAnswer(@RequestBody ComplaintAnswerDTO answer) {
    	return new ResponseEntity<Boolean>(complaintService.sendAnswer(answer), HttpStatus.OK);	      
	}

}
