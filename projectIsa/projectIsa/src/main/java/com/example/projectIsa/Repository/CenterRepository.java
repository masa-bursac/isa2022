package com.example.projectIsa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer>{
	
	public Center findOneById(Integer id);

	public List<Center> findAllById(Integer id);
}
