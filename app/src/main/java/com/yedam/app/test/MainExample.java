package com.yedam.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.yedam.app.xml.Restaurant;

public class MainExample {
     public static void main(String[] args) {
    	ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
     
    	Restaurant res = (Restaurant)ctx.getBean(Restaurant.class);
    	res.run();
     }	
}
