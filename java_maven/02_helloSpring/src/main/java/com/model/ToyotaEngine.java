package com.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary //指定選用
public class ToyotaEngine implements Engine {
	
	public void start() {
		System.out.println("ToyotaEngine 啟動");
	}
}
