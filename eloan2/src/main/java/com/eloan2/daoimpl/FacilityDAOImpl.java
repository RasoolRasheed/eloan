package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.FacilityDAO;
import com.eloan2.domain.Facility;

@Repository
public class FacilityDAOImpl implements FacilityDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Facility listDues(int fno) {
		Criteria cr = getSession().createCriteria(Facility.class);
		cr.add(Restrictions.eq("fno",fno));
		//(Student) crt.uniqueResult();
		List results = cr.list();
		
		return (Facility) cr.uniqueResult();	
		
	}

}
