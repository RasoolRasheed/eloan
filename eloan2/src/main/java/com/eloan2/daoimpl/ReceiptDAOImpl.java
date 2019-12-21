package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.ReceiptDAO;
import com.eloan2.domain.Due;
import com.eloan2.domain.OverPay;
import com.eloan2.domain.Receipt;

@Repository
public class ReceiptDAOImpl implements ReceiptDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	@Override
//	public Due listDues(int fno){
//		Criteria crt = getSession().createCriteria(Due.class);
//		crt.add(Restrictions.eq("fno", fno));
//		return (Due) crt.uniqueResult();
//	}
	
	public List<Due> getDuesById(int fno) {
		Criteria crt = getSession().createCriteria(Due.class);
			crt.add(Restrictions.eq("fno", fno));
		List results = crt.list();
		
		return results;
	}
	
	public void updatePayment(Due due) {
		getSession().update(due);
	}
	
	public Due getDuesId(int id) {
		Due st = (Due)getSession().get(Due.class,id);
		return st;
	}
	
	public void overPay(OverPay op) {
		getSession().save(op);
	}
	
	public Receipt getReceiptId(int fno) {
		Receipt rc = (Receipt)getSession().get(Receipt.class,fno);
		return rc;
	}
	
	public Receipt getAllById(int fno) {
		Receipt rc = (Receipt)getSession().get(Receipt.class,fno);
		return rc;
	}
	
	public void createReceipt(Receipt rcpt) {
		 getSession().save(rcpt);
	}
	public Due getPaymentBYId(int id) {
		Criteria crt = getSession().createCriteria(Due.class);
		crt.add(Restrictions.eq("fno", id));
		
		return (Due) crt.uniqueResult();
	}
}
