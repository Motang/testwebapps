package com.sf.nirvana.os.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.nirvana.os.web.entity.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/info")
	@ResponseBody
	public User getUserInfo(HttpServletRequest request) {
		return new User();
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello!123";
	}
	
}
