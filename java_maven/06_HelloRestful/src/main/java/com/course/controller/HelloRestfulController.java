package com.course.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

import io.swagger.v3.oas.annotations.Operation;

//@Controller
@RestController//=Controller + ResponseBody
//@RequestMapping("/kitty") //加上URL
//@CrossOrigin("*")
//@CrossOrigin("http://127.0.0.1:5500/")
@CrossOrigin(origins = { "http://127.0.0.1:5500/" }, allowedHeaders = "*", allowCredentials = "true")
public class HelloRestfulController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	// GetMapping
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
//	@ResponseBody
	public String hello2() {
		return "hello2";
	}
	
	@Operation(summary = "取得使用者", description = "詳細描述", tags = { "使用者專用" })
	@GetMapping("/users")
	public List<User> users(){
		User user1 = new User("kitty","1234");
		User user2 = new User("snoopy","1234");
		return Arrays.asList(user1,user2);
	}
	
	@Operation(summary = "新增使用者", description = "新增詳細描述", tags = { "使用者專用" })
	@PostMapping("/json/users")
	public User addUserJson(@RequestBody User user) {
		user.setUsername(user.getUsername() + "!!!!!");
		return user;
	}
	
	
	@PutMapping("/json/user")
	public User updateUserJson(@RequestBody User user) {
		user.setUsername(user.getUsername() + "!!!!!");
		return user;
	}
	
	@PatchMapping("/json/user")
	public User updatePatchUserJson(@RequestBody User user) {
		user.setUsername(user.getUsername() + "!!!!!");
		return user;
	}
	
	@DeleteMapping("/json/user/{username}")
	public void updatePatchUserJson(@PathVariable String  username) {
		System.out.println("@DeleteMapping: " + username);
		// 刪除
	}
	
	@GetMapping("/ok")
	public String ok() {
	    return "OK!!!!!!";
	}
	
	@GetMapping("/ok2")//實務會用ResponseEntity 但影響不大
	public ResponseEntity<String> ok2() {
	    return ResponseEntity.ok("OK!!!!!!");
	}
	
	@GetMapping("/no-ok")
	public ResponseEntity<String> noOk() {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO!!!!!!");
	}
}
