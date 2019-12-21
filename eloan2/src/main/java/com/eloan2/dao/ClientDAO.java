package com.eloan2.dao;

import java.util.List;

import com.eloan2.domain.Client;
import com.eloan2.domain.SecurityTypes;

public interface ClientDAO {
	public void createClient(Client cln);

	public List<Client> listClient();

	public List<Client> getClientByNIC(String NIC);

	public String getClntByNIC(String NIC);

	public Client getClientByClientCode(int clientCode);

	public void updateClient(Client cln);
}
