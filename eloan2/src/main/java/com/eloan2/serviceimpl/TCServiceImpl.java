package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.TCDAO;
import com.eloan2.domain.RentalSchedule;
import com.eloan2.domain.TC;
import com.eloan2.service.TCService;

@Transactional
@Service
public class TCServiceImpl implements TCService {
	@Autowired
	private TCDAO tcDAO;

	public TCDAO getTcDAO() {
		return tcDAO;
	}

	public void setTcDAO(TCDAO tcDAO) {
		this.tcDAO = tcDAO;
	}

	@Override
	public void createTC(TC tc) {
		getTcDAO().createTC(tc);
	}

	@Override
	public void saveSchedule(RentalSchedule sche) {
		getTcDAO().saveSchedule(sche);
	}

	public TC getTCNOByClientCode(int clientCode) {
		return getTcDAO().getTCNOByClientCode(clientCode);
	}

}
