package jwd.wafepa.service;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;

public interface LogService {
	Log save(Log activity);
	ArrayList<Log> findAll();
}
