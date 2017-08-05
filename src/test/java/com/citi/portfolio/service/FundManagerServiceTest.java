package com.citi.portfolio.service;

import javax.annotation.Resource;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.FundManager;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class FundManagerServiceTest {

	private static Logger logger = Logger.getLogger(FundManagerServiceTest.class);  
//    private ApplicationContext ac = null;  
    @Resource
    private FundManagerService fundManagerService;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
//      fundManagerService = (FundManagerService) ac.getBean("fundManagerService");  
//  }  
  
    @Test  
    public void test1() {  
        FundManager manager = fundManagerService.getManagerById(1);  
        System.out.println(manager);  
        logger.info(JSON.toJSONString(manager));  
    }  
}
