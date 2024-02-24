package com.jey.factory;

public interface Vehicle {
	 void drive();
}

class Car implements Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving car...");
	}
}

class Bike implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Riding bike...");	
	}	
}

class Truck implements Vehicle{
	@Override
	public void drive() {
		System.out.println("Driving Truck...");	
	}
}
