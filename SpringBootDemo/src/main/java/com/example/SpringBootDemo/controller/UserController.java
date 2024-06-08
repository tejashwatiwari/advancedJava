package com.example.SpringBootDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.beans.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/message")
	public String getDemo() {
		return "Welcome to Springboot Demo";

	}

	@GetMapping
	public List<User> getUser() {
		User user = new User();
		user.setName("Teja");
		user.setAge(24);
		user.setAddress("Fulla");

		User user2 = new User();
		user.setName("Tejaaa");
		user.setAge(25);
		user.setAddress("Hulla");

		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user2);
		return users;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		System.out.println(user);
		// save in db next
		return user;
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		System.out.println(user);
		// update in db next
		return user;
	}

	@DeleteMapping
	public User deleteUser(@RequestParam("id") String id) {
		System.out.println("Deleted ID" + id);
		return new User();
	}

}
