package com.yhd.project.projectmvc.common.hibernate3;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LogEntityInterceptor extends EmptyInterceptor implements
		ApplicationContextAware {

	private static final long serialVersionUID = -8597658125309889388L;
	private static final Logger log = LoggerFactory
			.getLogger(LogEntityInterceptor.class);

	private ApplicationContext appCtx;
	private SessionFactory sessionFactory;

	public static final String SESSION_FACTORY = "sessionFactory";

	// private Logger logger = Logger.getLogger(LogEntityInterceptor.class);
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// logger.info("删除数据");
		System.out.println("删除数据");

	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] preState, String[] propertyNames,
			Type[] types) {
		// logger.info("修改数据");

		System.out.println("修改数据");
		
		assert (propertyNames.length == currentState.length);

		for (int i = 0; i < propertyNames.length; i++) {
			if ("updateTime".equals(propertyNames[i])) {
				currentState[i] = new Date();
				return true;
			}
		}


		return false;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] State,
			String[] propertyNames, Type[] types) {
		// logger.info("保存数据");
		System.out.println("保存数据");

		// return false;
		return true;
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx)
			throws BeansException {
		// TODO Auto-generated method stub
		this.appCtx = appCtx;
	}

	protected SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = (SessionFactory) appCtx.getBean(SESSION_FACTORY,
					SessionFactory.class);
			if (sessionFactory == null) {
				throw new IllegalStateException("not found bean named '"
						+ SESSION_FACTORY
						+ "',please check you spring config file.");
			}
		}
		return sessionFactory;
	}

	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
}
