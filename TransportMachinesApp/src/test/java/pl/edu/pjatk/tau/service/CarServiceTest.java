package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.BMW.BMWFactory;
import pl.edu.pjatk.tau.domain.factory.Citroen.CitroenFactory;
import pl.edu.pjatk.tau.domain.factory.Renault.RenaultFactory;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
//import org.hamcrest.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CarServiceTest {
	
	public static CarService carService;
	public static Car car1;
	public static Car car2;
	public static Car car3;
	
	@BeforeClass
	public static void initCarServiceClass() {
		carService = new CarService();
	}
	
	@Before
	public void initSampleTestCars() {
		car1 = new Car(1, new BMWFactory());
		car2 = new Car(2, new CitroenFactory());
		car3 = new Car(3, new RenaultFactory());
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void ShouldInitializeEmptyDatabase() {
		TreeMap<Integer, Car> db = new CarDb().getDb();
		assertNotNull(db);
	}

	@Test
	public void ShouldReturnCarOfKnownId() {
		//Car car = new Car(1, new BMWFactory());
		carService.cars.put(1, car1);
		assertNotNull(carService.readById(1));
	}

	@Test
	public void shouldThrowExceptionForReadCarWhichNotExist() {
		exception.expect(IndexOutOfBoundsException.class);
		carService.readById(3);
	}
	
	@Test
	public void shouldAddNewCarIntoDatabase() {
		//Car car = new Car(1, new CitroenFactory());
		carService.create(car1);
		assertNotNull(carService.readById(1));
	}
	
	/*
	@Test
	public void shouldAddNewCarWithUniqueIdIntoDatabase() {
		Car car
	}
	*/
}
