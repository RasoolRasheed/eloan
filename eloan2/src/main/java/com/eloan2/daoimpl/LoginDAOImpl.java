package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.LoginDAO;
import com.eloan2.domain.Due;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.domain.Users;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean checkLogin(String username, String password) {
		boolean userFound = false;
		Criteria cr = getSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		
		// cr.add(Restrictions.eq("groupCode",groupCode));
		List results = cr.list();
		if ((results != null) && (results.size() > 0)) {
			userFound = true;
		}
		return userFound;
	}

	public Users getGroupCodeByUser(String username) {
		Criteria crt = getSession().createCriteria(Users.class);
		crt.add(Restrictions.eq("username", username));
		
		return (Users) crt.uniqueResult();

	}

}