package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.ComplaintStaff;

@Repository
public interface ComplaintStaffRepository extends JpaRepository<ComplaintStaff, Integer> {

}
