package pl.edu.pjatk.tau.domain.factory.Citroen;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.ProducentData;

public class CitroenProducentData implements ProducentData{
	
	
	public Car getProducentData() {
		return car;
	}
	
	
	public void initializeProducentData() {
		car.setMark("Citroen");
		car.setModel("C5");
		car.setProducentCountry("France");
		car.setYearOfProduction(2017);
	}
}
