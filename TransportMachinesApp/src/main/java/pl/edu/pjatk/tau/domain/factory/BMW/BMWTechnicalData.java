package pl.edu.pjatk.tau.domain.factory.BMW;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.TechnicalData;

public class BMWTechnicalData implements TechnicalData{
	
	
	public Car getTechnicalData() {
		initializeTechnicalData();
		return car;
	}
	
	
	public void initializeTechnicalData() {
		car.setEngineType("Diesel");
		car.setGearboxType("Manual");
		car.setMaxSpeed(270);
	}
}
