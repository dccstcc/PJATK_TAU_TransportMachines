package pl.edu.pjatk.tau.service;

import java.time.LocalDateTime;
import java.util.TreeMap;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;

public interface ITimestampService extends ICarService {
	
	public TreeMap<Integer, CarTimestamp> getCarsTime();
	public CarTimestamp carCasting(Car car);
	public String dateFormatter(LocalDateTime now);
	
}
