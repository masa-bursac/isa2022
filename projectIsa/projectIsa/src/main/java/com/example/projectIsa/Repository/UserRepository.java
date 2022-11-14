package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.CenterAdministrator;
import com.example.projectIsa.DTO.RegistrationDTO;
import com.example.projectIsa.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findOneByEmail(String email);
	CenterAdministrator findOneById(Integer id);
}
