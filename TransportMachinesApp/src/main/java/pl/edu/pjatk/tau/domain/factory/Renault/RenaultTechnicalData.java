package pl.edu.pjatk.tau.domain.factory.Renault;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.TechnicalData;

public class RenaultTechnicalData implements TechnicalData{
	
	
	public Car getTechnicalData() {
		initializeTechnicalData();
		return car;
	}
	
	
	public void initializeTechnicalData() {
		car.setEngineType("Petrol");
		car.setGearboxType("Manual");
		car.setMaxSpeed(240);
	}
}
