package com.yhd.project.projectmvc.module.login.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yhd.project.projectmvc.common.hibernate3.HibernateBaseDao;
import com.yhd.project.projectmvc.common.hibernate3.Updater;
import com.yhd.project.projectmvc.module.login.dao.ProjectmvcUserDao;
import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;

@Repository("ProjectmvcUserDao")
public class ProjectmvcUserDaoImpl extends HibernateBaseDao<ProjectmvcUser, Integer> implements
		ProjectmvcUserDao {

	@Override
	public ProjectmvcUser findByUserName(String username){
//		YhdmvcUser yhdmvcUser = findUniqueByPropery(YhdmvcUser.PROP_LOGIN_NAME, username);
		//YhdmvcUser yhdmvcUser = findUniqueByPropery("LoginName", username);
		
		String hql = " from ProjectmvcUser where loginName =:loginname" ;
		Query query = getSession().createQuery(hql).setParameter("loginname", username);;
		ProjectmvcUser projectmvcUser = (ProjectmvcUser)query.uniqueResult();
		
		return projectmvcUser;
	}
	
	@Override
	public ProjectmvcUser updateProjectmvcUser(ProjectmvcUser projectmvcUser) {
		
		Updater<ProjectmvcUser> updater = new Updater<ProjectmvcUser>(projectmvcUser);
		projectmvcUser = updateByUpdater(updater);
		
		return projectmvcUser;
	}
	
	@Override
	protected Class<ProjectmvcUser> getEntityClass() {

		return ProjectmvcUser.class;
	}
}
