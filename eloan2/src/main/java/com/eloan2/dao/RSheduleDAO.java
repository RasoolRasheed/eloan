package com.eloan2.dao;

import java.util.List;

import com.eloan2.domain.LStatus;

public interface RSheduleDAO {
	public List<LStatus> listLStatus();
	public void updateLStatus(LStatus st);
	public void removeLStatus(int sno);
	public LStatus getLStatusId(int sno);
}
