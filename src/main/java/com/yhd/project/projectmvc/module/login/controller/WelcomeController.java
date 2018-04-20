package com.yhd.project.projectmvc.module.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;
import com.yhd.project.projectmvc.module.login.manager.ProjectmvcUserManager;

import net.sf.json.JSONObject;

@Controller
public class WelcomeController {

	@RequestMapping("/index.do")
	public String index(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping("/userlist.do")
	public void userlist(HttpServletRequest request,
			HttpServletResponse response, String userName, ModelMap modelMap) {

		String login_name = request.getSession().getAttribute("login_name")
				.toString();
		ProjectmvcUser projectmvcUser = projectmvcUserManager.findByUserName(login_name);

		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("appId", sign.get("appId"));
		// jsonObject.put("timestamp", sign.get("timestamp"));
		// jsonObject.put("nonceStr", sign.get("nonceStr"));
		// jsonObject.put("signature", sign.get("signature"));
		//
		// response.getWriter().write(jsonObject.toString());

		// System.out.println(JSONArray.fromObject(yhdmvcUser));
		JSONObject jsonObject = JSONObject.fromObject(projectmvcUser);

		System.out.println(jsonObject);

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		//return jsonObject;
		
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/userUpdate.do")
	public void userUpdate(HttpServletRequest request,
			HttpServletResponse response, String description, ModelMap modelMap) {

		String login_name = request.getSession().getAttribute("login_name")
				.toString();
		ProjectmvcUser projectmvcUser = projectmvcUserManager.findByUserName(login_name);
		projectmvcUser.setDescription(description);
		projectmvcUserManager.updateProjectmvcUser(projectmvcUser);

		JSONObject jsonObject = JSONObject.fromObject(projectmvcUser);

		System.out.println(jsonObject);

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		//return jsonObject;
		
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private ProjectmvcUserManager projectmvcUserManager;
	
	@Autowired
	public void setProjectmvcUserManager(ProjectmvcUserManager dao) {
		this.projectmvcUserManager = dao;
	}
}
