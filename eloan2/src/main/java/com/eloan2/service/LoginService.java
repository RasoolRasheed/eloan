package com.eloan2.service;

import com.eloan2.domain.Users;

public interface LoginService {
	public boolean checkLogin(String username, String password);
	public Users getGroupCodeByUser(String username);
}
