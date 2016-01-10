package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Activity;

public interface ActivityService {

	Activity findOne(Long id);
	Page<Activity> findAll(int page, int pageSize);
	Activity save(Activity activity);
	void remove(Long id) throws IllegalArgumentException;
	List<Activity> findByName(String string);
}
