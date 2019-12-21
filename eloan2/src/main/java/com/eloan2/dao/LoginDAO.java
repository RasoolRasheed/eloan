package com.eloan2.dao;

import com.eloan2.domain.Users;

public interface LoginDAO {
	public boolean checkLogin(String username, String password);

	public Users getGroupCodeByUser(String username);
}
