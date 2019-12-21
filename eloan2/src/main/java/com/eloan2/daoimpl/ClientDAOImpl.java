package com.eloan2.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eloan2.dao.ClientDAO;
import com.eloan2.domain.Client;
import com.eloan2.domain.LStatus;

@Repository
public class ClientDAOImpl implements ClientDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createClient(Client cln) {
		getSession().save(cln);

	}
	public List<Client> listClient(){
		Criteria cr = getSession().createCriteria(Client.class);
		List results = cr.list();
			
		return results;
	}
	
	public List<Client> getClientByNIC(String NIC){
		Criteria crt = getSession().createCriteria(Client.class);
			crt.add(Restrictions.eq("NIC", NIC));
		List results = crt.list();
	
	return results;
	}
	
	public String getClntByNIC(String NIC){
		Criteria crt = getSession().createCriteria(Client.class);
			crt.add(Restrictions.eq("NIC", NIC));
		String results = crt.toString();
	
	return results;
	}
	public Client getClientByClientCode(int clientCode){
		Client clnt = (Client) getSession().get(Client.class,clientCode);
		return clnt;
	}
	public void updateClient(Client cln) {
		getSession().update(cln);
	}
}
