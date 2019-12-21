package com.eloan2.service;

import java.util.List;

import com.eloan2.domain.Client;
import com.eloan2.domain.RentalSchedule;
import com.eloan2.domain.TC;

public interface TCService {
	public void saveSchedule(RentalSchedule sche);

	public void createTC(TC tc);
	
	public TC getTCNOByClientCode(int clientCode);
}
