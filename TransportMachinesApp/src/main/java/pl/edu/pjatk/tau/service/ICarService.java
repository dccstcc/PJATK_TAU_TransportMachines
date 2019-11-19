package pl.edu.pjatk.tau.service;

import java.util.ArrayList;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public interface ICarService {
	
	public CarDb db = new CarDb();
	public TreeMap<Integer, Car> carsDb = db.getDb();
	
	public Car readById(int id);
}
