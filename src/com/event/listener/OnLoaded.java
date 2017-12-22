package com.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.service.impl.FileServiceImpl;

@Component
public class OnLoaded implements ApplicationListener<ContextRefreshedEvent> {
	static public Logger logger = LoggerFactory.getLogger("OnLoaded"); 

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info(event.toString());
		// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		if(event.getApplicationContext().getParent() == null){
			//root application context 没有parent，他就是老大.
			logger.info("\n-----------------\n onload \n --1234567-- \n-------------\n"+event.toString());
			
			new FileServiceImpl().initDirs();
			
		}
	}
}