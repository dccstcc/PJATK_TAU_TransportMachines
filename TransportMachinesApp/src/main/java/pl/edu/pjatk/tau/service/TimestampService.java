package pl.edu.pjatk.tau.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;

public class TimestampService extends CarService implements ITimestampService {
	
	//CarTimestamp database
	private TreeMap<Integer, CarTimestamp> carsT = new TreeMap<Integer, CarTimestamp>();
		
	public TreeMap<Integer, CarTimestamp> getCarsTime() {
		return carsT;
	}
	
	public int create(Car car, LocalDateTime timestamp) {
		
		//add Car into super class object and get operation return code
		int ret = super.create(car);
		
		//get cars from super class object TreeMap database
		TreeMap<Integer, Car> cars = super.getCars();
		
		//clone Car object form super.database class to this.database TreeMap
		for(Map.Entry<Integer, Car> entry : cars.entrySet()) {
			
			//read Car object from super.database class
			Car superCar = entry.getValue();
			
			//if Car from method argument is equal to Car from super.database then goto under statements
			if(carCompareCarTimestamp(superCar, car)) {
				
				CarTimestamp carT = new CarTimestamp();
				//cast from Car to CarTimestamp object
				carT = carCasting(superCar);
				//add timestamp into CarTimestamp object 
				carT.setWriteTimestamp(timestamp);
				//get Car id from super.database class
				int id = superCar.getId();
				//add CarTimestamp into this.database with id from super.database
				carsT.put(id, carT);
			}
		}
		
		return ret;
	}
	
	@Override
	public CarTimestamp readById(int id) {
		boolean throwException = true;
		CarTimestamp result = new CarTimestamp();
		for(Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet()) {
			if(entry.getKey().equals(id)) {
				this.getCarsTime().get(id).setReadTimestamp(actualTime());
				result = this.getCarsTime().get(id);
				throwException = false;
				break;
			} 
		}
		
		if(throwException) throw new IndexOutOfBoundsException();
				
		return result;
	}
	
//	public int update(CarTimestamp carT) {
//		Car car = carCasting(carT);
//		int result = super.update(car);
//		car = super.readById(id)
//		return result;
//	}
	
	//cast form CarTimestamp to Car object
	public CarTimestamp carCasting(Car car) {
		CarTimestamp result = new CarTimestamp();
		result.setId(car.getId());
		result.setMark(car.getMark());
		result.setModel(car.getModel());
		result.setProducentCountry(car.getProducentCountry());
		result.setYearOfProduction(car.getYearOfProduction());
		result.setColor(car.getColor());
		result.setEngineType(car.getEngineType());
		result.setGearboxType(car.getGearboxType());
		result.setMaxSpeed(car.getMaxSpeed());
		result.setSegmentType(car.getSegmentType());
		result.setProductVersion(car.getProductVersion());
		result.setPrice(car.getPrice());
		return result;		
	}
	
	public boolean carCompareCarTimestamp(Car superCar, Car car) {
		boolean result = false;
		result = superCar.getMark() == car.getMark() ? true : false;
		result = superCar.getModel() == car.getModel() ? true : false;
		result = superCar.getProducentCountry() == car.getProducentCountry() ? true : false;
		result = superCar.getYearOfProduction() == car.getYearOfProduction() ? true: false;
		result = superCar.getColor() == car.getColor() ? true : false;
		result = superCar.getEngineType() == car.getEngineType() ? true : false;
		result = superCar.getGearboxType() == car.getEngineType() ? true : false;
		result = superCar.getMaxSpeed() == car.getMaxSpeed() ? true : false;
		result = superCar.getSegmentType() == car.getSegmentType() ? true : false;
		result = superCar.getProductVersion() == car.getProductVersion() ? true : false;
		result = superCar.getPrice() == car.getPrice() ? true : false;
		return result;
	}
	
	//for future use
	public LocalDateTime actualTime() {
		return LocalDateTime.now();
	}
	
	//for future use
	public String dateFormatter(LocalDateTime now) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String result = now.format(formatter);
		return result;
	}
}

