package pl.edu.pjatk.tau.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;

public class CarService implements ICarService{
	
	private CarDb db = new CarDb();
	private TreeMap<Integer, Car> cars = db.getDb();
	
	public TreeMap<Integer, Car> getCars() {
		return cars;
	}
	
	// return car of given id or throw exception if car don't exist
	public Car readById(int id) {
		boolean throwException = true;
		Car result = new Car();
		for(Map.Entry<Integer, Car> entry : cars.entrySet()) {
			if(entry.getKey().equals(id)) {
				result = cars.get(id);
				throwException = false;
				break;
			} 
		}
		
		if(throwException) throw new IndexOutOfBoundsException();
		
		return result;
	}
	
	public int create(Car car) {
		
		
		int id = 0;
		boolean doubleKeys = false;
		boolean singleKeys = false;
		ArrayList<Integer> keys = new ArrayList<Integer>();
		int returnCode = -1;
		
		//add car only if car.id is unique else run loop for double keys
		for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
			if( ! entry.getKey().equals(car.getId())) {
				singleKeys = true;
			}
			else {
				singleKeys = false;
				doubleKeys = true;
				break;
			}
		}
		
		//keys are unique; add Car
		if(singleKeys) {
			id = car.getId();
			returnCode = 1;
		}
		
		//key are double
		if(doubleKeys) {
			
			// create ascending array of keys
			int nullId = 1;
			for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
				if(nullId == entry.getKey()) {
					keys.add(entry.getKey());
				} else {
					keys.add(null);				
				}
				nullId++;
			}		
			
			int freeKey = 0;
			for(Object key : keys) {
				freeKey++;
				if(Objects.isNull(key)) 
					id = freeKey;
					returnCode = 2;
					break;
			}
		}
		  
		car.setId(id);
		this.getCars().put(id, car);
		return returnCode;
	}
}
