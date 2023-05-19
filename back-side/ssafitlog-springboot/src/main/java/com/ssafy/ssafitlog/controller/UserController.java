package com.ssafy.ssafitlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/user")
public class UserController {
	
	@Autowired
	private UserService userService;

}
