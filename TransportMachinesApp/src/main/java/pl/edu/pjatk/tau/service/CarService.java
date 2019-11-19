package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.BMW.BMWFactory;

public class CarService implements ICarService{

	public Car readById(int id) {
		Car car = new Car(1, new BMWFactory());
		carsDb.put(1, car);
		return carsDb.get(1);
	}
}
