package com.ssafy.ssafitlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.service.ExpService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/exp")
public class ExpController {
	
	@Autowired
	private ExpService expService;

}
