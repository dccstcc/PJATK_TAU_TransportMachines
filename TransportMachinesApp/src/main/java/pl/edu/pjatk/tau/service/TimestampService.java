package pl.edu.pjatk.tau.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;

public class TimestampService extends CarService implements ITimestampService, ISearchingService, IDeleteService {
	
	//CarTimestamp database
	private TreeMap<Integer, CarTimestamp> carsT = new TreeMap<Integer, CarTimestamp>();
	
	//activation flags for timestamps
	private boolean isWriteActive = true;
	private boolean isReadActive = true;
	private boolean isUpdateActive = true;
	
	public TreeMap<Integer, CarTimestamp> getCarsTime() {
		return carsT;
	}
	
	//flags activation/deactivation methods
	public void disableWriteTS() {
		this.isWriteActive = false;
	}
	public void enableWriteTS() {
		 this.isWriteActive = true;
	}
	public void disableUpdateTS() {
		this.isUpdateActive = false;
	}
	public void enableUpdateTS() {
		 this.isUpdateActive = true;
	}
	public void disableReadTS() {
		this.isReadActive = false;
	}
	public void enableReadTS() {
		 this.isReadActive = true;
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
				//add timestamp into CarTimestamp object if flag is active
				if(isWriteActive) carT.setWriteTimestamp(timestamp);
				//get Car id from super.database class
				int id = superCar.getId();
				//add CarTimestamp into this.database with id from super.database
				carsT.put(id, carT);
			}
		}
		
		return ret;
	}
	
	@Override
	public int create(Car car) {
		return(create(car, actualTime()));
	}
	
	@Override
	public CarTimestamp readById(int id) {
		boolean throwException = true;
		CarTimestamp result = new CarTimestamp();
		
		for(Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet()) {
			//find CarTimestamp obj by id
			if(entry.getKey().equals(id)) {
				//set read timestamp in CarTimestamp obj directly into db 
				//only if timestamp read flag is active
				if(isReadActive)
				this.getCarsTime().get(id).setReadTimestamp(actualTime());
				//read CarTimestamp obj with read timestamp from db
				result = this.getCarsTime().get(id);
				
				throwException = false;
				break;
			} 
		}
		
		//when nothing found
		if(throwException) throw new IndexOutOfBoundsException();
				
		return result;
	}
	
	@Override
	public int update(Car car) {
		//call super.class update method
		int ret = super.update(car);
		//remember id of CarTimestamp obj
		int id = car.getId();
		//read CarTimestamp by id
		CarTimestamp carT = this.getCarsTime().get(id);
		
		//remember timestamps from CarTimestamp obj
		LocalDateTime readT = carT.getReadTimestamp();
  		LocalDateTime writeT = carT.getWriteTimestamp();
  		LocalDateTime updateT = carT.getUpdateTimestamp();
		boolean isReadT = carT.isActiveReadTS();
		boolean isWriteT = carT.isActiveWriteTS();
		boolean isUpdateT = carT.isActiveUpdateTS();
		
		//cast from Car to CarTimestamp
		carT = carCasting(car);
		//restore remembered timestamps from CarTimestamps obj
		carT.setReadTimestamp(readT);
		carT.setWriteTimestamp(writeT);
		carT.setUpdateTimestamp(updateT);
		carT.setActiveReadTS(isReadT);
		carT.setActiveWriteTS(isWriteT);
		carT.setActiveUpdateTS(isUpdateT);
		
		//set actual update timestamp if update timestamp flag is active
		if(isUpdateActive) carT.setUpdateTimestamp(actualTime());
		
		//replace old CarTimestamp to actual version
		this.getCarsTime().replace(id, this.getCarsTime().get(id), carT);
		
		return ret;
	}
			
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
	
	///////
	//
	//	ISearchingService interface implementation
	//
	///////
	
	public ArrayList<String> getSearch() {
		return this.searchResults;
	}
	
	public boolean isSearchEmpty() {
		return this.searchResults.get(0).equals("Nothing found") ? true : false;
	}
	
//	public void searchCar(String params) {
//		for (Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet()) {
//			String carStr = concatCarParams(entry.getValue());
//			int idx = 0;
//			String substr = "";
//			while(params.length() > 0) {
//				idx = params.indexOf(" ");
//				substr = params.substring(0, idx);
//				if (carStr.contentEquals(substr)) {
//					this.searchResults.concat(carStr + "\n");
//					break;
//				} else {
//					params = params.substring(idx);
//				}
//			}
//		}
//	}
	
	public void searchCar(String params) {
		String result = "";
		int id = 0;
		for (Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet()) {
			//stringify CarTimestamp object to carStr
			String carStr = concatCarParams(entry.getValue());
			//split stringified CarTimestamp object to single words
			String[] carParts = carStr.split(" ");
			//if key-word from splitting equals key-word params method argument
			//then car object was found
			//add founded car into searching database
			for(int i=0; i<carParts.length; i++) {
				if(params.contains(carParts[i])) {
					result = concatCarParams(entry.getValue());
					getSearch().add(result);
					break;
				}
			}
		}
		//if nothing found
		if(getSearch().isEmpty()) {
			getSearch().add("Nothing found");
		}
	}
	
	private String concatCarParams(Car car) {
		String result = "";
		
		//result.concat(car.getId() + " ");
		result.concat(car.getMark() + " ");
		result.concat(car.getModel() + " ");
		result.concat(car.getProducentCountry() + " ");
		result.concat(car.getYearOfProduction() + " ");
		result.concat(car.getColor() + " ");
		result.concat(car.getEngineType() + " ");
		result.concat(car.getGearboxType() + " ");
		result.concat(car.getMaxSpeed() + " ");
		result.concat(car.getSegmentType() + " ");
		result.concat(car.getProductVersion() + " ");
		result.concat(String.valueOf(car.getPrice()));
		
		return result;
	}
	
	public CarTimestamp parseStringToCar(String carStr) throws NullPointerException{
		CarTimestamp car = new CarTimestamp();
		
		String[] parts = carStr.split(" ");
		int idx = 0;
		String val = "";
		
		try {
		val = parts[idx++];
		car.setMark(val);
		
		val = parts[idx++];
		car.setModel(val);
		
		val = parts[idx++];
		car.setProducentCountry(val);
		
		val = parts[idx++];
		car.setYearOfProduction(Integer.parseInt(val));
		
		val = parts[idx++];
		car.setColor(val);
		
		val = parts[idx++];
		car.setEngineType(val);
		
		val = parts[idx++];
		car.setGearboxType(val);
		
		val = parts[idx++];
		car.setMaxSpeed(Integer.parseInt(val));
		
		val = parts[idx++];
		car.setSegmentType(val);
		
		val = parts[idx++];
		car.setProductVersion(val);
		
		val = parts[idx++];
		car.setPrice(Integer.parseInt(val));
		
		}catch(NullPointerException e) {
			//e.("last parts = " + val);
			//e.printStackTrace();
		}
		
		return car;
	}
	
	///////
	//
	//	IDeleteService interface implementation
	//
	///////
	
	public ArrayList<CarTimestamp> getDelList() {
		return this.toDeleteCars;
	}
	
	public int deleteFromList(ArrayList<CarTimestamp> toDeleteList) {
		int count = 0;
		int idx = 0;
		//loop for car delete list
		for(CarTimestamp cdel : toDeleteList) {
			
			//interior loop for all cars into db
 			for (Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet()) {
				//car comparision
 				if(this.carCompareCarTimestamp(cdel, entry.getValue())) {
 					//if cars are equals then remember id car from db
 					idx = entry.getKey();
 					count++;
 					break;
 				}
			}
 			//remove car by id from db
 			this.getCarsTime().remove(idx);
		}
		
		return count;
	}
	
	@Override
	public int delete(Car car) {
		int count = 0;
		int idx = 0;
		
		//loop for cars into database
		for (Map.Entry<Integer, CarTimestamp> entry : this.getCarsTime().entrySet())  {
			//car comparison
			if(this.carCompareCarTimestamp(car, entry.getValue())) {
				//if cars are equals then remember id car form db
				idx = entry.getKey();
				count = 1;
				break;
			}
		}
		
		//delete car by id from database
		this.getCarsTime().remove(idx);

		//how many car was deleted
		return count;
	}

 
	
//	public CarTimestamp parseStringToCar(String carStr) {
//		CarTimestamp car = new CarTimestamp();
//		
//		int idx = carStr.indexOf(" ");
//		String val = carStr.substring(0, idx);
//		car.setMark(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setModel(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setProducentCountry(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setYearOfProduction(Integer.parseInt(val));
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setColor(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setEngineType(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setGearboxType(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setMaxSpeed(Integer.parseInt(val));
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setSegmentType(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setProductVersion(val);
//		carStr = carStr.substring(idx);
//		
//		idx = carStr.indexOf(" ");
//		val = carStr.substring(0, idx);
//		car.setPrice(Integer.parseInt(val));
//		carStr = carStr.substring(idx);
//		
//		return car;
//	}
}

