package pl.edu.pjatk.tau.service;

import java.util.Map;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public class CarService implements ICarService{
	
	CarDb db = new CarDb();
	TreeMap<Integer, Car> cars = db.getDb();
	
	public Car readById(int id) {
		Car result = new Car();
		for(Map.Entry<Integer, Car> entry : cars.entrySet()) {
			if(entry.getKey().equals(id)) {
				result = cars.get(id);
			} else {
				throw new IndexOutOfBoundsException();
			}
				
		}
		return result;
	}
}
