package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.LAppraisalDAO;
import com.eloan2.domain.Due;
import com.eloan2.domain.Facility;
import com.eloan2.domain.LAppraisal;
import com.eloan2.domain.TC;

@Repository
public class LAppraisalDAOImpl implements LAppraisalDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * String hql = "FROM Employee E Where E.id=10"; Query<R> query =
	 * session.createQuery(hql); List results = query.list();
	 */
	
	public List<LAppraisal> listAppraisals() {	
		//get loan application details
		Criteria cr = getSession().createCriteria(LAppraisal.class);
		cr.add(Restrictions.eq("currentStatus","A"));
		
		List<LAppraisal> results = cr.list();
		return results;
	}
	
	public void initiateApp(Facility fclty) {
		getSession().save(fclty);
	}
	public void addPrepayments(Due duefromclnt) {
		getSession().save(duefromclnt);
	}
	public void updateSecurityTypes(LAppraisal lapsl) {
		/*
		 * Criteria crit = getSession().createCriteria(LAppraisal.class);
		 * crit.add(Restrictions.eq("applicationNo", "F"));
		 */
		getSession().update(lapsl);
	}
	
	public LAppraisal getAppStatusByTCNo(int TCNo) {
		Criteria crit = getSession().createCriteria(LAppraisal.class);
		crit.add(Restrictions.eq("TCNo",TCNo));
		return (LAppraisal) crit.uniqueResult();
	}
	public List<TC> listTc(int TCNo){
		Criteria crt = getSession().createCriteria(TC.class);
		crt.add(Restrictions.eq("TCNo", TCNo));
		List results = crt.list();
		
		return results;
	}
}
