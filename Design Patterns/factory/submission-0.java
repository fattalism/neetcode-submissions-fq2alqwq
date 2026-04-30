interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    @Override 
    public Car createVehicle(){
        Car car = new Car();
        return car;
    }

}

class BikeFactory extends VehicleFactory {
     @Override 
    public Bike createVehicle(){
        Bike bike = new Bike();
        return bike;
    }

}

class TruckFactory extends VehicleFactory {
     @Override 
    public Truck createVehicle(){
        Truck truck = new Truck();
        return truck;
    }

}
