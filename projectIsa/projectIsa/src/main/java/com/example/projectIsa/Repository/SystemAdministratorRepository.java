package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.SystemAdminstrator;

@Repository
public interface SystemAdministratorRepository extends JpaRepository<SystemAdminstrator, Integer> {

}
