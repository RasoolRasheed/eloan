package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.ActivationDAO;
import com.eloan2.domain.Due;

@Repository
public class ActivationDAOImpl implements ActivationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean checkBalance(int fno) {
		boolean chkblnce = false;
		Criteria crt = getSession().createCriteria(Due.class);
		crt.add(Restrictions.eq("fno", fno));
  		crt.add(Restrictions.eq("balance", 0));
		chkblnce = true;
		return chkblnce;
	}

	public List<Due> getDuesById(int fno) {
		Criteria crt = getSession().createCriteria(Due.class);
			crt.add(Restrictions.eq("fno", fno));
		List results = crt.list();
		
		return results;
	}
}
