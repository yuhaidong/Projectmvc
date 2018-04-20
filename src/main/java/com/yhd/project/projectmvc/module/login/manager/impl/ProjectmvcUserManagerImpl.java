package com.yhd.project.projectmvc.module.login.manager.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhd.project.projectmvc.module.login.dao.ProjectmvcUserDao;
import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;
import com.yhd.project.projectmvc.module.login.manager.ProjectmvcUserManager;

@Transactional
@Service("ProjectmvcUserManager")
public class ProjectmvcUserManagerImpl implements ProjectmvcUserManager {

//	@Autowired
//	public void setBloUserDao(YhdmvcUserDao yhdmvcUserDao) {
//		this.dao = yhdmvcUserDao;
//	}

	@Override
	@Transactional(readOnly = true)
	public ProjectmvcUser findByUserName(String username) {
		ProjectmvcUser entity = dao.findByUserName(username);
		return entity;
	}
	
	public ProjectmvcUser updateProjectmvcUser(ProjectmvcUser projectmvcUser) {
		
		ProjectmvcUser user = dao.updateProjectmvcUser(projectmvcUser);
		
		return user;
	}

	@Resource
	private ProjectmvcUserDao dao;

	@Autowired
	public void setDao(ProjectmvcUserDao dao) {
		this.dao = dao;
	}

	public ProjectmvcUserDao getDao() {
		return dao;
	}
}
