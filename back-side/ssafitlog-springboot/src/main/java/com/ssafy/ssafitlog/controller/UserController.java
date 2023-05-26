package com.ssafy.ssafitlog.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Autowired
	private ResourceLoader resLoader;

	@ApiOperation(value = "로그인", notes = "암호화, jwt적용")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> doLogin(User user) {

		User loginUser = userService.getUser(user.getUserId());
//		boolean flag = encrypt.getEncrypt(user.getPassword()).equals(loginUser.getPassword());
		boolean flag = true;

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
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable String userId){
		
		User user = userService.getUser(userId);
		
		if(user == null) {	
			return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
	}

	@ApiOperation(value = "이메일 발송", notes = "발사")
	@PostMapping("/email")
	public ResponseEntity<?> sendEmail(String email) {

		Integer result = userService.getUserByEmail(email);

		int randomCode = emailUtil.sendEmail(email);
		return new ResponseEntity<Integer>(randomCode, HttpStatus.OK);

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
	@PostMapping("")
	public ResponseEntity<?> modifyUser(@RequestParam("userId") String userId,
			@RequestParam("userComment") String userComment,
			@RequestParam("file") MultipartFile file) throws IOException {
		Resource res = resLoader.getResource("classpath:static/resources/upload");
		if (!res.getFile().exists()) {
			res.getFile().mkdirs();
		}
		
		User user = new User();
		user.setUserId(userId);
		user.setUserComment(userComment);
		user.setImg(file.getOriginalFilename());
		file.transferTo(new File(res.getFile(), file.getOriginalFilename()));
		
		int result = userService.modifyUser(user);
		
		if(result > 0) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


	}
	
	@GetMapping("/img/{imgSrc}")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public Resource getImage(@PathVariable String imgSrc) {
		return resLoader.getResource("classpath:static/resources/upload/" + imgSrc);
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
	
	@GetMapping("/searchImg")
	public ResponseEntity<?> searchUserImg(String userId){
		
		String img = userService.searchUserImg(userId);
		
		if(userId != null) {
			return new ResponseEntity<String>(img, HttpStatus.OK);
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
	
	@GetMapping("/userInfo/{userId}")
	public ResponseEntity<?> searchuserReviewCount(@PathVariable String userId){
		Integer result = userService.searchUserReviewCount(userId);
		if (result == null) {
			result = 0;
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
