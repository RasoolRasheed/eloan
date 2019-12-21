package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.UserDAO;
import com.eloan2.domain.Users;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createUser(Users usr) {
		getSession().save(usr);
	}

	@Override
	public Users getStudentById(int id) {
		Users users = (Users) getSession().get(Users.class, id);
		return users;
	}

	@Override
	public List<Users> listUsers() {
		Criteria cr = getSession().createCriteria(Users.class);
		List results = cr.list();
		return results;
	}

	public void removeStudent(int id) {
		Users usr = (Users) getSession().get(Users.class, id);
		this.getSession().delete(usr);
	}

	public void updateUsers(Users usr) {
		getSession().update(usr);
	}
}
