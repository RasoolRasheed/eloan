package com.eloan2.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.TCDAO;
import com.eloan2.domain.RentalSchedule;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.domain.TC;

@Repository
public class TCDAOImpl implements TCDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createTC(TC tc) {
		getSession().save(tc);
	}

	public void saveSchedule(RentalSchedule sche) {
		getSession().save(sche);
	}

	public TC getTCNOByClientCode(int clientCode) {
		TC tc = (TC)getSession().get(TC.class, clientCode);
		return tc;
	}

}
