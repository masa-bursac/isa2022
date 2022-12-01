package com.example.projectIsa.Service;

import java.util.List;

import com.example.projectIsa.DTO.ComplaintDTO;
import com.example.projectIsa.Model.Complaint;

public interface IComplaintService {

	List<ComplaintDTO> getAllComplaints();
}
