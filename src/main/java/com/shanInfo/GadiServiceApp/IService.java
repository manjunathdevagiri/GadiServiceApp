package com.shanInfo.GadiServiceApp;

import java.util.List;

public interface IService {
	public void addService() throws Exception;
	public List<Service_Records> getService()throws Exception;
}
