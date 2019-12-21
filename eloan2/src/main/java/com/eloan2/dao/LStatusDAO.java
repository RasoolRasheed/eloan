package com.eloan2.dao;

import java.util.List;

import com.eloan2.domain.LStatus;

public interface LStatusDAO {
	public void createLStatus(LStatus lsts);
	public List<LStatus> listLStatus();
	public void updateLStatus(LStatus st);
	public void removeLStatus(int sno);
	public LStatus getLStatusId(int sno);
}
