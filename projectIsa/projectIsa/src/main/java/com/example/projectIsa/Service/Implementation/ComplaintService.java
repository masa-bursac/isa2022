package com.example.projectIsa.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projectIsa.DTO.ComplaintDTO;
import com.example.projectIsa.Model.Complaint;
import com.example.projectIsa.Model.ComplaintCenter;
import com.example.projectIsa.Model.ComplaintStaff;
import com.example.projectIsa.Model.ComplaintType;
import com.example.projectIsa.Repository.ComplaintCenterRepository;
import com.example.projectIsa.Repository.ComplaintRepository;
import com.example.projectIsa.Repository.ComplaintStaffRepository;
import com.example.projectIsa.Service.IComplaintService;

@Service
public class ComplaintService implements IComplaintService {

	private final ComplaintRepository complaintRepository;
	private final ComplaintCenterRepository complaintCenterRepository;
	private final ComplaintStaffRepository complaintStaffRepository;
	
	public ComplaintService(ComplaintRepository complaintRepository, ComplaintCenterRepository complaintCenterRepository,
			 ComplaintStaffRepository complaintStaffRepository) {
		this.complaintRepository = complaintRepository;
		this.complaintCenterRepository = complaintCenterRepository;
		this.complaintStaffRepository = complaintStaffRepository;
	}

	@Override
	public List<ComplaintDTO> getAllComplaints() {
		List<Complaint> allComplaints = complaintRepository.findAll();
		List<ComplaintDTO> complaints = new ArrayList<ComplaintDTO>();
		ComplaintDTO complaintDTO = new ComplaintDTO();
		for(Complaint complaint: allComplaints){
			complaintDTO = setComplaintData(complaint);
			complaints.add(complaintDTO);
		}
		return complaints;
	}
	
	public ComplaintDTO setComplaintData(Complaint complaint) {
		ComplaintCenter complaintCenter = new ComplaintCenter();
		ComplaintStaff complaintStaff = new ComplaintStaff();
		ComplaintDTO complaintDTO = new ComplaintDTO(complaint);
		if(complaint.getType().equals(ComplaintType.CENTER)) {
			complaintCenter = complaintCenterRepository.findById(complaint.getId()).get();
			complaintDTO.setCenterId(complaintCenter.getCenter().getId());
			complaintDTO.setCenterName(complaintCenter.getCenter().getName());
		}
		else if(complaint.getType().equals(ComplaintType.STAFF)) {
			complaintStaff = complaintStaffRepository.findById(complaint.getId()).get();
			complaintDTO.setCenterId(complaintStaff.getCenterAdministrator().getCenter().getId());
			complaintDTO.setStaffName(complaintStaff.getCenterAdministrator().getName());
			complaintDTO.setStaffSurname(complaintStaff.getCenterAdministrator().getSurname());
			complaintDTO.setCenterName(complaintStaff.getCenterAdministrator().getCenter().getName());
		}
		return complaintDTO;

		
	}

}
