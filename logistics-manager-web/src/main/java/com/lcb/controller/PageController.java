package com.lcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 所有直接访问根目录的请求跳转到main.jsp
	 * @return
	 */
	@RequestMapping("/")
	public String showMain(){
		return "main";
	}
	
	@RequestMapping("/{path}")
	public String showOther(@PathVariable String path){
		return path;
	}
}
