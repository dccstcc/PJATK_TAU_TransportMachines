package pl.edu.pjatk.tau.service;

import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public interface ICarService {
		
	public TreeMap<Integer, Car> getCars();
	public Car readById(int id);
	public int create(Car car);
	public TreeMap<Integer, Car> readAll();
	public int update(Car car);
	public int delete(Car car);
}
