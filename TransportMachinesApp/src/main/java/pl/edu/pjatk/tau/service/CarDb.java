package pl.edu.pjatk.tau.service;

import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public class CarDb implements ICarDb{
	
	public TreeMap<Integer, Car> getDb() {
		return db;
	}
}
