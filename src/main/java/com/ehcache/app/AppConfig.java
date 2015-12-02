package com.ehcache.app;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@ComponentScan({ "com.ehcache.app.*" })
@ImportResource("classpath:Spring-Config.xml")
public class AppConfig {
	
	@Bean(name = "aceCacheDAO")
	public ACECacheDAO aceCacheDAO() {
		return new ACECacheDAOImpl();
	}

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		System.out.println("cache config");
		return cmfb;
	}

	/*@Bean
    public CacheManager defaultCacheManager() {
        return new ConcurrentMapCacheManager("books");
    }*/
	
}