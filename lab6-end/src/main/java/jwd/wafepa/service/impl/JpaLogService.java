package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jwd.wafepa.model.Log;
import jwd.wafepa.repository.LogRepository;
import jwd.wafepa.service.LogService;

@Transactional
@Service
public class JpaLogService implements LogService {

	@Autowired
	private LogRepository logRepository;
	
	@Override
	public Log save(Log log) {
		return logRepository.save(log);
	}

	@Override
	public ArrayList<Log> findAll() {
		return logRepository.findAll();
	}

}
