package com.eloan2.dao;

import com.eloan2.domain.RentalSchedule;
import com.eloan2.domain.SecurityTypes;
import com.eloan2.domain.TC;

public interface TCDAO {
	public void saveSchedule(RentalSchedule sche);

	public void createTC(TC tc);
	
	public TC getTCNOByClientCode(int clientCode);

}
