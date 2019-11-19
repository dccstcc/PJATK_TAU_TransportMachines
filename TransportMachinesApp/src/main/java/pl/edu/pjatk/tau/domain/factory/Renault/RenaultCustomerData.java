package pl.edu.pjatk.tau.domain.factory.Renault;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.CustomerData;

public class RenaultCustomerData implements CustomerData{
	
	public Car getCustomerData() {
		return car;
	}
	
	
	public void initializeCustomerData() {
		car.setColor("Silver");
		car.setSegmentType("C");
		car.setProductVersion("sport");
		car.setPrice(65000);
	}
}
