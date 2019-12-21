package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.SecurityTypesDAO;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.service.SecurityTypesService;

@Transactional
@Service
public class SecurityTypesServiceImpl implements SecurityTypesService {
	@Autowired
	private SecurityTypesDAO stDAO;
	
	public SecurityTypesDAO getStDAO() {
		return stDAO;
	}

	public void setStDAO(SecurityTypesDAO stDAO) {
		this.stDAO = stDAO;
	}

	@Override
	public void createSecurityTypes(SecurityTypes st) {
		getStDAO().createSecurityTypes(st);
	}

	@Override
	public List<SecurityTypes> listSecurityTypes() {
		return getStDAO().listSecurityTypes();
	}

	@Override
	public void updateSecurityTypes(SecurityTypes st) {
		this.getStDAO().updateSecurityTypes(st);

	}

	@Override
	public void removeSecurityTypes(int id) {
		this.getStDAO().removeSecurityTypes(id);

	}

	@Override
	public SecurityTypes getSecurityTypesId(int id) {
		return this.getStDAO().getSecurityTypesId(id);
	}

}
