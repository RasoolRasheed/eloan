package com.eloan2.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloan2.dao.LAppraisalDAO;
import com.eloan2.domain.Due;
import com.eloan2.domain.Facility;
import com.eloan2.domain.LAppraisal;
import com.eloan2.domain.TC;
import com.eloan2.service.LAppraisalService;

@Transactional
@Service
public class LAppraisalServiceImpl implements LAppraisalService {
	@Autowired
	private LAppraisalDAO lapprslDAO;
	
	public LAppraisalDAO getLapprslDAO() {
		return lapprslDAO;
	}
	public void setLapprslDAO(LAppraisalDAO lapprslDAO) {
		this.lapprslDAO = lapprslDAO;
	}

	public List<LAppraisal> listAppraisals(){
		return this.getLapprslDAO().listAppraisals();
	}
	
	public void initiateApp(Facility fclty) {
		getLapprslDAO().initiateApp(fclty);
	}
	
	public void addPrepayments(Due duefromclnt) {
		getLapprslDAO().addPrepayments(duefromclnt);
	}
	public void updateSecurityTypes(LAppraisal lapsl) {
		getLapprslDAO().updateSecurityTypes(lapsl);
	}
	public LAppraisal getAppStatusByTCNo(int TCNo) {
		return this.getLapprslDAO().getAppStatusByTCNo(TCNo);
	}
	public List<TC> listTc(int TCNo){
		return this.getLapprslDAO().listTc(TCNo);
	}
}
