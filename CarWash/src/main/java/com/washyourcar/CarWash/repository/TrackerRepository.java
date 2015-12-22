package com.washyourcar.CarWash.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.washyourcar.CarWash.Model.Tracker;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {

	ArrayList<Tracker> findAll();
}
