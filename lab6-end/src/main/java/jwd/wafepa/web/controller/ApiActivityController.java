package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.web.dto.ActivityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/activities")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityDTO>> getActivities (
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize){
		
		List<ActivityDTO> activities = new ArrayList<>();
		
		int totalPages=0;
		long totalElements = 0;
		
		if (value == null) {
			Page<Activity> activitiesPage = activityService.findAll(page, pageSize);
			for (Activity a : activitiesPage) {
				if (a.deleted == null){
					activities.add(new ActivityDTO(a));
				}
				
			}
			totalPages = activitiesPage.getTotalPages();
			totalElements = activitiesPage.getTotalElements();
		} else {
			for (Activity a : activityService.findByName(value)) {
				activities.add(new ActivityDTO(a));
			}
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", "" + totalPages);
		httpHeaders.add("total-elements", "" + totalElements);
		
		return new ResponseEntity<>(activities, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id) {
		Activity activity = activityService.findOne(id);
		if (activity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ActivityDTO(activity), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ActivityDTO> deleteActivity(@PathVariable Long id) {
		Activity activity = activityService.findOne(id);
		if (activity != null) {
			activityService.remove(id);
			return new ResponseEntity<>(new ActivityDTO(activity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ActivityDTO> addActivity(@RequestBody ActivityDTO activityDto) {

		Activity activity = new Activity();
		activity.setName(activityDto.getName());
		activity.setCreated(new Date());
		activity.setHidden(activityDto.isHidden());
		
		
		Activity activityPersisted = activityService.save(activity);

		return new ResponseEntity<>(new ActivityDTO(activityPersisted), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<ActivityDTO> editActivity(
			@PathVariable Long id, 
			@RequestBody ActivityDTO activityDto) {

		Activity activity = activityService.findOne(id);
		if (activity != null) {
			if (id != activityDto.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			activity.setName(activityDto.getName());
			activity.setHidden(activityDto.isHidden());
			activity.setDeleted(new Date());
			
			Activity persistedActivity = activityService.save(activity);

			return new ResponseEntity<>(new ActivityDTO(persistedActivity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
