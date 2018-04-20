package com.yhd.project.projectmvc.module.login.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yhd.project.projectmvc.module.login.entity.ProjectmvcUser;
import com.yhd.project.projectmvc.module.login.manager.ProjectmvcUserManager;

public class ProjectmvcAuthorizingRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
//		FlxoaUser flxoaUser = flxoaUserMng.findByUserName(token.getUsername());
		ProjectmvcUser flxoaUser = projectmvcUserManager.findByUserName(token.getUsername());

		if (flxoaUser != null) {
			return new SimpleAuthenticationInfo(flxoaUser.getDisplayName(),
					flxoaUser.getPassword(), getName());
		}

		return null;
	}

	protected ProjectmvcUserManager projectmvcUserManager;

//	@Autowired
//	public void setFlxoaUserMng(YhdmvcUserManager yhdmvcUserManager) {
//		this.yhdmvcUserManager = yhdmvcUserManager;
//	}
	
	@Autowired
	public void setProjectmvcUserManager(ProjectmvcUserManager projectmvcUserManager) {
		this.projectmvcUserManager = projectmvcUserManager;
	}

}
