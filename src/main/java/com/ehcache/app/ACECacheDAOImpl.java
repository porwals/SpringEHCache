package com.ehcache.app;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

@Resource
public class ACECacheDAOImpl implements ACECacheDAO{
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	DataSource dataSource;

	public CacheManager getCacheManager() {
		return cacheManager;
	}
	
	@Override
	public String getErrorMessage(String errCode) {
		ValueWrapper vW = getCacheManager().getCache("errMsgCache").get(errCode);
		return (vW == null || vW.get() == null) ? "" : (String) vW.get();
	}

	@Override
	public String getPropertyMessage(String propertyCode) {
		ValueWrapper vW = getCacheManager().getCache("propMsgCache").get(propertyCode);
		return (vW == null || vW.get() == null) ? "" : (String) vW.get();
	}

	@Override
	public String getGenericMessage(String genericCode) {
		ValueWrapper vW = getCacheManager().getCache("genMsgCache").get(genericCode);
		return (vW == null || vW.get() == null) ? "" : (String) vW.get();
	}

	void loadCache()
	{
		List<ErrorMsg> errs = new ACECacheDAOHelper(dataSource).getErrorMessages();
		for (ErrorMsg err : errs)
		{
			getCacheManager().getCache("errMsgCache").put(err.getErrCode(), err.getErrMsg());
		}
		
		System.out.println("Error Message Loaded in Cache");
	}
	
	

}
