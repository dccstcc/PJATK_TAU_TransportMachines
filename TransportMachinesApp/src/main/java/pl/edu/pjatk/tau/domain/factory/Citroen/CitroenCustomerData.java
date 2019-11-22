package pl.edu.pjatk.tau.domain.factory.Citroen;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.CustomerData;

public class CitroenCustomerData implements CustomerData{
	
	public Car getCustomerData() {
		initializeCustomerData();
		return car;
	}
	
	
	public void initializeCustomerData() {
		car.setColor("Red");
		car.setSegmentType("D");
		car.setProductVersion("comfort");
		car.setPrice(70000);
	}
}
