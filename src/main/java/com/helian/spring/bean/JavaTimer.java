package com.helian.spring.bean;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaTimer implements Job{
	public JavaTimer(){}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		  System.out.println("1111111"+(new Date()).toString());
	}
	public void helloTest(){
		System.out.println("1111111"+(new Date()).toString());
	}
	public static void main(String[] args) {  
	    // TODO Auto-generated method stub  
	        System.out.println("加载spring配置文件....");  
	      ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/spring-mapper.xml");  
	      System.out.println("加载配置文件完毕!");  
	 }  
}
