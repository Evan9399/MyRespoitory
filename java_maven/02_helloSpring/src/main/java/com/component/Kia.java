package com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model.Engine;

@Component
@Scope("prototype")
public class Kia {
	@Autowired //可以放在定義、constructor、setter
	@Qualifier("benzEngine")
	private Engine engine;

	public Kia(@Qualifier("benzEngine")Engine engine) {
		super();
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
