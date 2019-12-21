package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.SecurityTypesDAO;
import com.eloan2.domain.SecurityTypes;

@Repository
public class SecurityTypesDAOImpl implements SecurityTypesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createSecurityTypes(SecurityTypes st) {
		getSession().save(st);

	}

	@Override
	public List<SecurityTypes> listSecurityTypes() {
		Criteria cr = getSession().createCriteria(SecurityTypes.class);
		List results = cr.list();
		return results;
	}

	@Override
	public void updateSecurityTypes(SecurityTypes st) {
		getSession().update(st);
	}

	@Override
	public void removeSecurityTypes(int id) {
		SecurityTypes st = (SecurityTypes) getSession().get(SecurityTypes.class, id);
		this.getSession().delete(st);

	}

	@Override
	public SecurityTypes getSecurityTypesId(int id) {
		SecurityTypes st = (SecurityTypes) getSession().get(SecurityTypes.class, id);
		return st;
	}

}
