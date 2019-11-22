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
	public static Car bmw;
	public static Car citroen;
	public static Car renault;
	
	@Before
	public void initCarServiceClass() {
		carService = new CarService();
	}
	
	@Before
	public void initSampleTestCars() {
		bmw = new Car(1, new BMWFactory());
		citroen = new Car(2, new CitroenFactory());
		renault = new Car(3, new RenaultFactory());
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
		carService.getCars().put(1, bmw);
		assertNotNull(carService.readById(1));
	}

	@Test
	public void shouldThrowExceptionForReadCarWhichNotExist() {
		exception.expect(IndexOutOfBoundsException.class);
		carService.readById(3);
	}
	
	@Test
	public void shouldAddNewCarIntoDatabase() {
		carService.create(bmw);
		assertNotNull(carService.readById(1));
	}
	
	@Test
	public void shouldAddNewCarWithTheSameIdIntoDatabase() {
		carService.create(citroen);
		carService.create(citroen);
		carService.create(citroen);
		assertEquals(carService.getCars().size(), 3);
	}
	
}
