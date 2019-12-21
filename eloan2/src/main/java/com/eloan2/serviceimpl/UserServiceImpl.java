package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.UserDAO;
import com.eloan2.domain.Users;
import com.eloan2.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setStudentDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void createUser(Users usr) {
		getUserDAO().createUser(usr);

	}

	@Override
	public List<Users> listUsers() {
		return this.userDAO.listUsers();

	}

	@Override
	public void updateUsers(Users usr) {
		this.userDAO.updateUsers(usr);
	}

	@Override
	public Users getStudentById(int id) {
		return this.userDAO.getStudentById(id);
	}

	@Override
	public void removeStudent(int id) {
		this.userDAO.removeStudent(id);
	}

}
