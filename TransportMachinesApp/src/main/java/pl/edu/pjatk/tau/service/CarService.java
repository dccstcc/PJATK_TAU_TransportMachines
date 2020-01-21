package pl.edu.pjatk.tau.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
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
		for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
			if(entry.getKey().equals(id)) {
				result = this.getCars().get(id);
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
		
		//add car if database is empty
		if(this.getCars().isEmpty()) {
			id = car.getId();

			returnCode = 1;
		}
		
		//keys are unique; add Car
		if(singleKeys) {
			id = car.getId();
			returnCode = 2;
		}
		
		//key are double
		if(doubleKeys) {
			
			// create ascending array of keys
			for(int i = 0; i <= this.getCars().lastKey(); i++ ) {
				if(this.getCars().containsKey(i)) {
					keys.add(i);

				} else {
					keys.add(-1);
				}
			}
			
			
			//find free key
			int freeKey = 0;
			for(int key : keys) {
				if(key == -1) {
					id = freeKey;
					returnCode = 3;
					break;
				}
				freeKey++;
			}
			id = freeKey;		
		}
		
		//set unique id and add car to database
		car.setId(id);
		this.getCars().put(id, car);

		return returnCode;
	}
	
	
	
	public TreeMap<Integer, Car> readAll() {
		if(this.getCars().isEmpty()) throw new NullPointerException();
		return this.getCars();
	}
	
	
	
	public int update(Car car) {
		
		int returnCode = -1;
		boolean throwExc = true;
		
		if(this.getCars().isEmpty()) throw new NullPointerException();
		
		for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
			if(car.getId() == entry.getKey())  {
				
				throwExc = false;
			
				this.getCars().replace(entry.getKey(), entry.getValue(), car);
				//this.getCars().put(entry.getKey(), car);
				//this.getCars().replace(entry.getKey(), car);
				//entry.setValue(car);
				
				returnCode = 1;
			}
		}
		
		if(throwExc) throw new NoSuchElementException();
		
		return returnCode;
	}
	
	
	public int delete(Car car) {
		
		int returnCode = -1;
		boolean throwExc = true;
		int id = -1;
		
		if(this.getCars().isEmpty()) throw new NullPointerException();
		
		for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
			if(car.getId() == entry.getKey())  {
				throwExc = false;				
			} 
		}
		
		if(throwExc) throw new NoSuchElementException();

		for(Map.Entry<Integer, Car> entry : this.getCars().entrySet()) {
			if(car.getId() == entry.getKey())  {
								
				id = entry.getKey();
				this.getCars().remove(id);
				returnCode = 1;
				
				break;
			}
		}
		
	
		return returnCode;
	}
}
