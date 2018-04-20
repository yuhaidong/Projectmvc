package com.yhd.project.projectmvc.module.login.controller;

import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * 没有登陆的情况下，访问登陆界面时，url访问到这个action
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String input(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "login";
//		return "top";
//		return "index";
	}
	
	/**
	 * 如果登录不成功，shiro会请求转发到这个action，然后再跳到登录页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String submit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		
		System.out.println("login.do-submit");
		
		Object error = request.getAttribute(DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (error != null) {
			model.addAttribute("error", error);
		}
		
		return "login";
	}
}
