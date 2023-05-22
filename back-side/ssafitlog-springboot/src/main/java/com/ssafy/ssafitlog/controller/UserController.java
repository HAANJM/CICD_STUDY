package com.ssafy.ssafitlog.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
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
import com.ssafy.ssafitlog.util.Encrypt;
import com.ssafy.ssafitlog.util.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/ssafitlog/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private Encrypt encrypt;

	@Autowired
	private JwtUtil jwtUtil;

	@ApiOperation(value = "로그인", notes = "암호화, jwt적용")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> doLogin(User user) {

		User loginUser = userService.getUser(user.getUserId());
		boolean flag = encrypt.getEncrypt(user.getPassword()).equals(loginUser.getPassword());

		Map<String, Object> result = new HashMap<String, Object>();
		
		HttpStatus status = null;

		try {

			if (loginUser != null && flag) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("loginUser", loginUser);
				result.put("message", "SUCCESS");
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", "FAIL");
				status = HttpStatus.BAD_REQUEST;
			}
			
		} catch (UnsupportedEncodingException e) {
			result.put("message", "FAIL");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}

		return new ResponseEntity<Map<String, Object>>(result, status);
		
	}

	@ApiOperation(value = "이메일 발송", notes = "발사")
	@PostMapping("/email")
	public ResponseEntity<?> sendEmail(String email) {

		Integer result = userService.getUserByEmail(email);

		System.out.println(result);

		if (result != null) {
			return new ResponseEntity<Integer>(-1, HttpStatus.BAD_REQUEST);
		} else {
			int randomCode = emailUtil.sendEmail(email);
			return new ResponseEntity<Integer>(randomCode, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "회원 가입", notes = "회원 가입")
	@PostMapping("/regist")
	public ResponseEntity<?> userRegist(User user) {

		String encPwd = encrypt.getEncrypt(user.getPassword());

		user.setPassword(encPwd);

		int result = userService.userRegist(user);
		if (result > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@ApiOperation(value = "회원 정보 수정", notes = "정보수정")
	@PutMapping("")
	public ResponseEntity<?> modifyUser(User user) {
		
		int result = userService.modifyUser(user);
		
		if(result > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


	}
	
	@ApiOperation(value = "비밀번호 수정", notes = "비밀번호")
	@PutMapping("/pwd")
	public ResponseEntity<?> modifyPassword(User user){
		
		user.setPassword(encrypt.getEncrypt(user.getPassword()));
		
		int result = userService.modifyPassword(user);
		
		if(result > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchUserId(User user){
		
		String userId = userService.searchUserId(user);
		
		if(userId != null) {
			return new ResponseEntity<String>(userId, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteUser(User user) {

		int result = userService.deleteUser(user);

		if (result > 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
