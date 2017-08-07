package com.example.demo.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.web.domain.User;

@Controller
public class UserController {
	ArrayList<User> users = new ArrayList<>();
	
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("user/index");
		return mav;
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/user/login_failed")
	public String loginFailed() {
		return "user/login_failed";
	}
	
	@GetMapping("/users/{index}")
	public ModelAndView show(@PathVariable int index) {
		User user = users.get(index);
		
		ModelAndView mav = new ModelAndView("user/profile");
		mav.addObject(user);
		return mav;
	}
	
	@PostMapping("/users")
	public ModelAndView create(User user) {
		users.add(user);
		System.out.println("size : "+ users.size());
		
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/users")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("user", users);
		return mav;
	}
	
	@GetMapping("/user/form")
	public ModelAndView from() {
		ModelAndView mav = new ModelAndView("user/form");
		return mav;
	}
}
