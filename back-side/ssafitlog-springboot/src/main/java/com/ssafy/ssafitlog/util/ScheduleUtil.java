package com.ssafy.ssafitlog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ssafy.ssafitlog.model.service.UserService;

@Component
public class ScheduleUtil {
	
	@Autowired
	UserService userService;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void reviewCountInit() {
//		userService.reviewCountInit();
	}
}
