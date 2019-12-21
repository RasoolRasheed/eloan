package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.ClientDAO;
import com.eloan2.domain.Client;
import com.eloan2.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDAO clntdao;
	
	public ClientDAO getClntdao() {
		return clntdao;
	}
	
	public void setLstsdao(ClientDAO lstsdao) {
		this.clntdao = lstsdao;
	}

	@Override
	public void createClient(Client cln) {
		getClntdao().createClient(cln);
	}
	
	public List<Client> listClient(){
		return getClntdao().listClient();
	}
	
	public List<Client> getClientByNIC(String NIC){
		return getClntdao().getClientByNIC(NIC);
	}
	
	public String getClntByNIC(String NIC){
		return getClntdao().getClntByNIC(NIC);
	}
	
	public Client getClientByClientCode(int clientCode){
		return getClntdao().getClientByClientCode(clientCode);
	}
	
	public void updateClient(Client cln) {
		 this.getClntdao().updateClient(cln);;
	}
}
