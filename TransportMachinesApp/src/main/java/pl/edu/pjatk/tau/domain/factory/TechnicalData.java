package pl.edu.pjatk.tau.domain.factory;

import pl.edu.pjatk.tau.domain.Car;

public interface TechnicalData {
	
	public Car car  = new Car();
	
	public Car getTechnicalData();
	public void initializeTechnicalData();
}
