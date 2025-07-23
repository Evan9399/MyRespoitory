package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Toyota;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Toyota toyota = (Toyota)ctx.getBean("toyota1");//因為ctx.getbean是物件(object)所以要轉型
		toyota.move();// 建構式是空的 所以沒有引擎 藉由bean 裡面 constructor-arg 及bean 的engine 帶入就OK了
		
		for (String name : ctx.getBeanDefinitionNames()) {
			 System.out.println(name);
		 }
		 
		 System.out.println(toyota);
	}

}
