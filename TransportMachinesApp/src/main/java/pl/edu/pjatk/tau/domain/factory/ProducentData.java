package pl.edu.pjatk.tau.domain.factory;

import pl.edu.pjatk.tau.domain.Car;

public interface ProducentData {
	
	public Car car = new Car();
	
	public Car getProducentData();
	public void initializeProducentData();
}
