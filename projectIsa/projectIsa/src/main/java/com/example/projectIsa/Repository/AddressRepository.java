package com.example.projectIsa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.Model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer>{
}
