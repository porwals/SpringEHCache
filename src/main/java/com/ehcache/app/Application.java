package com.ehcache.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
//	@CacheEvict(value = "errMsgCache", allEntries=true)
//	public static Map<String, String> loadErrorMsg(CacheManager cm)
//	{
//		List<ErrorMsg> errs = getMongoTemplate().findAll(ErrorMsg.class);
//		Map<String, String> errMap = new HashMap<String, String>();
//		for (ErrorMsg err : errs)
//		{
////			errMap.put(err.getErrCode(), err.getErrMsg());
//			cm.getCache("errMsgCache").put(err.getErrCode(), err.getErrMsg());
//		}
//		System.out.println("Error Message Loaded");
//		
//		return errMap;
//	}
//	
//    private static MongoOperations getMongoTemplate()
//    {
//    	ApplicationContext ctx = 
//                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//    	MongoOperations mongoOperation = 
//                (MongoOperations) ctx.getBean("mongoTemplate");
//    	return mongoOperation;
//    }
	

}
