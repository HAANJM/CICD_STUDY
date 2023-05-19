package com.ssafy.ssafitlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.service.LikeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;

}
