package pl.edu.pjatk.tau.domain.factory.BMW;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.ProducentData;

public class BMWProducentData implements ProducentData{
	
	
	public Car getProducentData() {
		initializeProducentData();
		return car;
	}
	
	public void initializeProducentData() {
		car.setMark("BMW");
		car.setModel("X3");
		car.setProducentCountry("Germany");
		car.setYearOfProduction(2018);
	}
}
