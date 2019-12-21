package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.LStatusDAO;
import com.eloan2.dao.RSheduleDAO;
import com.eloan2.domain.LStatus;
import com.eloan2.service.LStatusService;
import com.eloan2.service.RSheduleService;

@Service
@Transactional
public class RSheduleServiceImpl implements RSheduleService {
	@Autowired
	private RSheduleDAO sheduleDAO;
	
	
	public RSheduleDAO getSheduleDAO() {
		return sheduleDAO;
	}
	
	public void setSheduleDAO(RSheduleDAO sheduleDAO) {
		this.sheduleDAO = sheduleDAO;
	}

	@Override
	
	public List<LStatus> listLStatus(){
		return getSheduleDAO().listLStatus();
	}
	
	@Override
	public void updateLStatus(LStatus st){
		this.getSheduleDAO().updateLStatus(st);

	}

	@Override
	public void removeLStatus(int id) {
		this.getSheduleDAO().removeLStatus(id);

	}

	@Override
	public LStatus getLStatusId(int id) {
		return this.getSheduleDAO().getLStatusId(id);
	}
}
