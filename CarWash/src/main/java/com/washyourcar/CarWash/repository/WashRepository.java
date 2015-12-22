package com.washyourcar.CarWash.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washyourcar.CarWash.Model.Wash;

@Repository
public interface WashRepository extends JpaRepository<Wash, Long> {

	ArrayList<Wash> findAll();
	
}
