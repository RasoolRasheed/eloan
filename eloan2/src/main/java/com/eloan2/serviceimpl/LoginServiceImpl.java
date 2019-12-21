package com.eloan2.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.LoginDAO;
import com.eloan2.domain.Users;
import com.eloan2.service.LoginService;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public boolean checkLogin(String username, String password) {

		return getLoginDAO().checkLogin(username, password);
	}

	public Users getGroupCodeByUser(String username) {
		return this.getLoginDAO().getGroupCodeByUser(username);
	}
}
