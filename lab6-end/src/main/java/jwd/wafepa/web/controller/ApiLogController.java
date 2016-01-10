package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.LogService;
import jwd.wafepa.service.UserService;
import jwd.wafepa.web.dto.ActivityDTO;
import jwd.wafepa.web.dto.LogDTO;

@RestController
@RequestMapping("api/logs")
public class ApiLogController {

	@Autowired
	private LogService logService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LogDTO> addLog(@RequestBody LogDTO logDto) {

		Log log = new Log();
		log.setDate(logDto.getDate());
		log.setDuration(logDto.getDuration());
		Activity activity = activityService.findOne(logDto.getActivity().getId());
		log.setActivity(activity);
		User user = userService.findOne(logDto.getUser().getId());
		log.setUser(user);

		Log logPersisted = logService.save(log);

		return new ResponseEntity<>(new LogDTO(logPersisted), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LogDTO>> getLogs(
			@RequestParam(value = "activityId", required = false) Long activityId,
			@RequestParam(value = "userId", required = false) Long userId) {
		
		List<LogDTO> logs = new ArrayList<>();
		// User user = userService.findOne(userId);
		
		if (activityId != null) {
			Activity activity = activityService.findOne(activityId);
			for (Log log : activity.getLogs()) {
				logs.add(new LogDTO(log));
			}
		}else if(userId != null){
			User user = userService.findOne(userId);
			for (Log log : user.getLogs()) {
				logs.add(new LogDTO(log));
			}
		} else {
			List<Log> logs2 = logService.findAll();
			for (Log l : logs2) {
				logs.add(new LogDTO(l));
			}
		}
		/*
		 * for (Log log : user.getLogs()) { logs.add(new LogDTO(log)); }
		 */
		return new ResponseEntity<>(logs, HttpStatus.OK);
	}

}
