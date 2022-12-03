package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.ComplaintAnswerDTO;
import com.example.projectIsa.DTO.ComplaintDTO;

public interface IComplaintService {

	List<ComplaintDTO> getAllComplaints();

	Boolean sendAnswer(ComplaintAnswerDTO answer);
}
