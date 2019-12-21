package com.eloan2.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.FacilityDAO;
import com.eloan2.domain.Facility;
import com.eloan2.service.FacilityService;

@Transactional
@Service
public class FacilityServiceImpl implements FacilityService {
	@Autowired
	private FacilityDAO rcptDAO;
	
	public FacilityDAO getRcptDAO() {
		return rcptDAO;
	}

	public void setRcptDAO(FacilityDAO rcptDAO) {
		this.rcptDAO = rcptDAO;
	}
	
	@Override
	public Facility listDues(int fno){
		return getRcptDAO().listDues(fno);
	}

}
