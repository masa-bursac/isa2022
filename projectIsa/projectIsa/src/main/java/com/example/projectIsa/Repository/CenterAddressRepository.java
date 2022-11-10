package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.CenterAddress;

@Repository
public interface CenterAddressRepository extends JpaRepository<CenterAddress, Integer>{
	CenterAddress findOneById(Integer id);

	CenterAddress findOneById(int id);
}
