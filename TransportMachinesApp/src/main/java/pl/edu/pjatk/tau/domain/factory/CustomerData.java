package pl.edu.pjatk.tau.domain.factory;

import pl.edu.pjatk.tau.domain.Car;

public interface CustomerData {
	
	public Car car = new Car();
	
	public Car getCustomerData();
	public void initializeCustomerData();
}
