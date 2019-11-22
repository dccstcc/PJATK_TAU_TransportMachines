package pl.edu.pjatk.tau.domain.factory.BMW;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.CustomerData;

public class BMWCustomerData implements CustomerData{
	
	public Car getCustomerData() {
		initializeCustomerData();
		return car;
	}
	
	
	public void initializeCustomerData() {
		car.setColor("White");
		car.setSegmentType("E");
		car.setProductVersion("comfort");
		car.setPrice(90000);
	}
}
