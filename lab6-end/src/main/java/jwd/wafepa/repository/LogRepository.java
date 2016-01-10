package jwd.wafepa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

	ArrayList<Log> findAll ();
}
