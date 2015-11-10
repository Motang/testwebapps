package com.sf.nirvana.os.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.nirvana.os.web.entity.User;

@RequestMapping("/main")
@Controller
public class MainController {

	@RequestMapping("/info")
	@ResponseBody
	public User getUserInfo(HttpServletRequest request) {
		return new User();
	}
	
	@RequestMapping("/pages/{type}/{func}")
	public String hello(@PathVariable String type,@PathVariable String func) {
		//return "type: "+type+", func: "+func;
		return "index2"; 
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
}
