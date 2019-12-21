package com.eloan2.service;

import java.util.List;

import com.eloan2.domain.Due;
import com.eloan2.domain.Facility;
import com.eloan2.domain.LAppraisal;
import com.eloan2.domain.TC;

public interface LAppraisalService {
	public void initiateApp(Facility fclty);
	public void addPrepayments(Due duefromclnt);
	public List<LAppraisal> listAppraisals();
	public void updateSecurityTypes(LAppraisal lapsl);
	public LAppraisal getAppStatusByTCNo(int TCNo);
	public List<TC> listTc(int TCNo);
}
