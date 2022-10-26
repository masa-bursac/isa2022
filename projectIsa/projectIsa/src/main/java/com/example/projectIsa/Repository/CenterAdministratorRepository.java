package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.CenterAdministrator;

@Repository
public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, Integer>{

}
