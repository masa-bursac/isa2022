package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.ComplaintCenter;

@Repository
public interface ComplaintCenterRepository extends JpaRepository<ComplaintCenter, Integer>{

}
