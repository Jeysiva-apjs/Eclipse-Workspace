package com.jey.factory;

public class VehicleStore {

	public static void main(String[] args) {
		VehicleFactory carFactory = new CarFactory();
		VehicleFactory truckFactory = new TruckFactory();
		VehicleFactory bikeFactory = new BikeFactory();

		Vehicle myCar = carFactory.createVehicle();
		Vehicle myTruck = truckFactory.createVehicle();
		Vehicle myBike = bikeFactory.createVehicle();

		myCar.drive();;   // "Car"
		myTruck.drive(); // "Truck"
		myBike.drive();  // "Bike"

	}

}
