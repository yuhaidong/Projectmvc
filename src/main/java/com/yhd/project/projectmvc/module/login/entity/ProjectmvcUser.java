package com.yhd.project.projectmvc.module.login.entity;
// Generated 2018-4-20 15:48:43 by Hibernate Tools 5.2.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProjectmvcUser generated by hbm2java
 */
@Entity
@Table(name = "projectmvc_user", catalog = "projectmvc")
public class ProjectmvcUser implements java.io.Serializable {

	private String id;
	private String loginName;
	private String displayName;
	private String password;
	private Date updateTime;
	private String description;

	public ProjectmvcUser() {
	}

	public ProjectmvcUser(String id) {
		this.id = id;
	}

	public ProjectmvcUser(String id, String loginName, String displayName, String password, Date updateTime,
			String description) {
		this.id = id;
		this.loginName = loginName;
		this.displayName = displayName;
		this.password = password;
		this.updateTime = updateTime;
		this.description = description;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "login_name", length = 100)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "display_name", length = 100)
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
