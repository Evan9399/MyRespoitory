package com.model;

public class Toyota /** extends ToyotaEngine */ {

	// private ToyotaEngine engine;
	private Engine engine;
	private Integer price;
	
	public Toyota() {
		
	}
	
	public Toyota(Engine engine, Integer price) {
		super();
		this.engine = engine;
		this.price = price;
	}

	public Toyota(Engine engine) {
	this.engine = engine;
	}
	public void move() {
		// ToyotaEngine engine = new ToyotaEngine();
		// engine.start();
		engine.start();
		System.out.println("Toyota 移動");
	}
	public String toString() {
		return "Toyota [price=" + price + ", engine=" + engine + "]";
	}
}
