package com.example.projectIsa.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.DTO.AppointmentDTO;
import com.example.projectIsa.Model.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findAllByCenterId(Integer centerId);
	
	List<Appointment> findAllByDate(LocalDateTime date);

	List<Appointment> findAllByRegUserId(Integer userId);
	
	Appointment findOneAppointmentById(Integer appointmentId);
}
