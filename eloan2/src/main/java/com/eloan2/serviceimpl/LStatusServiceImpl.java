package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.LStatusDAO;
import com.eloan2.domain.LStatus;
import com.eloan2.service.LStatusService;

@Service
@Transactional
public class LStatusServiceImpl implements LStatusService {
	@Autowired
	private LStatusDAO lstsdao;
	
	
	public LStatusDAO getLstsdao() {
		return lstsdao;
	}
	
	public void setLstsdao(LStatusDAO lstsdao) {
		this.lstsdao = lstsdao;
	}

	@Override
	public void createLStatus(LStatus lsts) {
		getLstsdao().createLStatus(lsts);
	}
	
	public List<LStatus> listLStatus(){
		return getLstsdao().listLStatus();
	}
	
	@Override
	public void updateLStatus(LStatus st){
		this.getLstsdao().updateLStatus(st);

	}

	@Override
	public void removeLStatus(int id) {
		this.getLstsdao().removeLStatus(id);

	}

	@Override
	public LStatus getLStatusId(int id) {
		return this.getLstsdao().getLStatusId(id);
	}
}
