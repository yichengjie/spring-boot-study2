package com.yicj.study.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloworldController{

	@GetMapping("/")
	public String index() {
		System.out.println("进入首页....");
		return "index" ;
	}

}
