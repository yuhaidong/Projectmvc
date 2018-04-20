package com.yhd.project.projectmvc.module.login.dao;

import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;

public interface ProjectmvcUserDao {

	public ProjectmvcUser findByUserName(String username);
	
	public ProjectmvcUser updateProjectmvcUser(ProjectmvcUser projectmvcUser);
}
