package com.ehcache.app;

public interface ACECacheDAO {
	
	public String getErrorMessage(String errCode);
	
	public String getPropertyMessage(String propertyCode);
	
	public String getGenericMessage(String genericCode);
}
