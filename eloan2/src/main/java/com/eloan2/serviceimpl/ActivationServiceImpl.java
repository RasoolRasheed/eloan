package com.eloan2.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.ActivationDAO;
import com.eloan2.service.ActivationService;

@Service
@Transactional
public class ActivationServiceImpl implements ActivationService {
	@Autowired
	private ActivationDAO activationDAO;
	
	public ActivationDAO getActivationDAO() {
		return activationDAO;
	}

	public void setActivationDAO(ActivationDAO activationDAO) {
		this.activationDAO = activationDAO;
	}

	@Override
	public boolean checkBalance(int fno) {
		return getActivationDAO().checkBalance(fno);
	}

}
