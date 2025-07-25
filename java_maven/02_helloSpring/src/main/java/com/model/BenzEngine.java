package com.model;

import org.springframework.stereotype.Component;

@Component
public class BenzEngine implements Engine {

	@Override
	public void start() {
		System.out.println("BenzEngine 啟動");
	}

}
