package pl.edu.pjatk.tau.domain.factory;

import pl.edu.pjatk.tau.domain.Car;

public interface CarFactory {
	
	public Car car = new Car();
	
	public ProducentData createProducentData();
	public TechnicalData createTechnicalData();
	public CustomerData createCustomerData();
}
