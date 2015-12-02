package com.ehcache.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class EHCacheController {
	
	@Autowired
	ACECacheDAO aceCacheDao;

    @RequestMapping(method = RequestMethod.GET, value="/{errCode}")
    @ResponseBody
    public HttpEntity<String> getError(@PathVariable String errCode) {
    	String errMsg = aceCacheDao.getErrorMessage(errCode);
    	
    	System.out.println("Fetched from Cache" + errMsg);
        return new HttpEntity<String>(errMsg);
    }
    
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    public HttpEntity<ErrorMsg> saveErrMsg(@RequestBody ErrorMsg err) {
//		
//    	MongoOperations mongoTmp = getMongoTemplate();
//    	mongoTmp.insert(err);
//    	
//    	return new ResponseEntity<ErrorMsg>(HttpStatus.CREATED);
//    }
    
//    private MongoOperations getMongoTemplate()
//    {
//    	ApplicationContext ctx = 
//                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//    	MongoOperations mongoOperation = 
//                (MongoOperations) ctx.getBean("mongoTemplate");
//    	return mongoOperation;
//    }
}
