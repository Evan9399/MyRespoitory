package com.model;

import com.model.Toyota;
import com.model.ToyotaEngine;

/** */
public class carMain {

	public static void main(String[] args) {
		Toyota toyota = new Toyota(new ToyotaEngine());
		toyota.move();

	}

}
