package com.yhd.project.projectmvc.module.login.manager;

import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;


public interface ProjectmvcUserManager {

	public ProjectmvcUser findByUserName(String username);
	
	public ProjectmvcUser updateProjectmvcUser(ProjectmvcUser projectmvcUser);
}
