package com.Alemeno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Alemeno.dto.ResponseStructure;
import com.Alemeno.dto.User;
import com.Alemeno.service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user ) {
		return userService.saveUser(user);
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	@GetMapping("/user/all")
	public ResponseEntity<ResponseStructure<List<User>>> getAll() {
		return userService.getAll();
	}
	

}
