package com.eloan2.service;

import java.util.List;

import com.eloan2.domain.SecurityTypes;

public interface SecurityTypesService {
	public void createSecurityTypes(SecurityTypes st);
	public List<SecurityTypes> listSecurityTypes();
	public void updateSecurityTypes(SecurityTypes st);
	public void removeSecurityTypes(int id);
	public SecurityTypes getSecurityTypesId(int id);
}
