package pl.edu.pjatk.tau.service;

import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public class CarDb implements ICarDb{

	private TreeMap<Integer, Car> db = new TreeMap<Integer, Car>();
	
	public TreeMap<Integer, Car> getDb() {
		return db;
	}
}
