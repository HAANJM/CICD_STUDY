package com.ssafy.ssafitlog.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafitlog.model.dto.User;
import com.ssafy.ssafitlog.model.service.UserService;
import com.ssafy.ssafitlog.util.EmailUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailUtil emailUtil;

	@ApiOperation(value="로그인", notes = "암호화, jwt적용")
	@PostMapping("")
	public ResponseEntity<?> doLogin(User user) {
		
		User loginUser = userService.getUser(user.getUserId());
		
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@ApiOperation(value="회원 정보 수정", notes="정보수정")
	@PutMapping("")
	public ResponseEntity<?> modifyUser(User user){
		
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteUser(User user){
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
