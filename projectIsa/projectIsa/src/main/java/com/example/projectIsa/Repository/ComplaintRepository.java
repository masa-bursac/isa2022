package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{


}
