package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.LStatusDAO;
import com.eloan2.domain.LStatus;

@Repository
public class LStatusDAOImpl implements LStatusDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createLStatus(LStatus lsts) {
		getSession().save(lsts);

	}
	public List<LStatus> listLStatus(){
		Criteria cr = getSession().createCriteria(LStatus.class);
		List results = cr.list();
			
		return results;
	}
	
	@Override
	public void updateLStatus(LStatus st) {
		getSession().update(st);
	}

	@Override
	public void removeLStatus(int id) {
		LStatus st = (LStatus) getSession().get(LStatus.class, id);
		this.getSession().delete(st);

	}

	@Override
	public LStatus getLStatusId(int id){
		LStatus st = (LStatus)getSession().get(LStatus.class,id);
		return st;
	}
}
