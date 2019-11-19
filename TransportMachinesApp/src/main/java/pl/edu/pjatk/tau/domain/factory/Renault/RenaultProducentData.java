package pl.edu.pjatk.tau.domain.factory.Renault;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.ProducentData;

public class RenaultProducentData implements ProducentData{
	
	
	public Car getProducentData() {
		return car;
	}
	
	
	public void initializeProducentData() {
		car.setMark("Renault");
		car.setModel("Megane");
		car.setProducentCountry("France");
		car.setYearOfProduction(2019);
	}
}
