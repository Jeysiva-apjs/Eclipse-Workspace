package com.jey.factory;

public interface VehicleFactory {
	
	Vehicle createVehicle();

}

class CarFactory implements VehicleFactory{
	@Override
	public Vehicle createVehicle() {
		return new Car();
	}
}
class BikeFactory implements VehicleFactory{
	@Override
	public Vehicle createVehicle() {
		return new Bike();
	}
}
class TruckFactory implements VehicleFactory{
	@Override
	public Vehicle createVehicle() {
		return new Truck();
	}
}
