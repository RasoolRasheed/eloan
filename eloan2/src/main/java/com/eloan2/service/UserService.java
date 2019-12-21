package com.eloan2.service;

import java.util.List;

import com.eloan2.domain.Users;

public interface UserService {
	public void createUser(Users usr);

	public List<Users> listUsers();

	public void updateUsers(Users usr);

	public void removeStudent(int id);

	public Users getStudentById(int id);
}
