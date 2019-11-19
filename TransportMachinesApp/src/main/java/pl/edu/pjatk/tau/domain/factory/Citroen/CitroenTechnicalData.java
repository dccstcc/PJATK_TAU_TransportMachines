package pl.edu.pjatk.tau.domain.factory.Citroen;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.TechnicalData;

public class CitroenTechnicalData implements TechnicalData{
	
	
	public Car getTechnicalData() {
		return car;
	}
	
	
	public void initializeTechnicalData() {
		car.setEngineType("Petrol");
		car.setGearboxType("Automatic");
		car.setMaxSpeed(260);
	}
}
