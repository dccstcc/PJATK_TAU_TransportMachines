package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.BMW.BMWFactory;
import pl.edu.pjatk.tau.domain.factory.Citroen.CitroenFactory;
import pl.edu.pjatk.tau.domain.factory.Renault.RenaultFactory;

import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarServiceTest {
	
	private CarService carService;
	private Car bmw;
	private Car citroen;
	private Car renault;
	
	@Before
	public void initCarServiceClass() {
		carService = new CarService();
	}
	
	@Before
	public void initSampleTestCars() {
		bmw = new Car(0, new BMWFactory());
		citroen = new Car(1, new CitroenFactory());
		renault = new Car(2, new RenaultFactory());
	}
	
	@After
	public void clearAllData() {
		carService.getCars().clear();
		bmw = null;
		citroen = null;
		renault = null;	
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
		carService.getCars().put(0, bmw);
		assertNotNull(carService.readById(0));
	}

	@Test
	public void shouldThrowExceptionForReadCarWhichNotExist() {
		exception.expect(IndexOutOfBoundsException.class);
		carService.readById(3);
	}
	
	@Test
	public void shouldAddNewCarIntoDatabase() {
		carService.create(bmw);
		assertNotNull(carService.readById(0));
	}
	
	@Test
	public void shouldAddNewCarWithTheSameIdIntoDatabase() {
		carService.create(renault);
		carService.create(renault);
		carService.create(renault);
		assertEquals(3, carService.getCars().size());
	}
	
	@Test
	public void shouldReturnTheSameCarWhichWasGivenForAddIntoDatabase() {
		carService.create(renault);
		Car car7 = new Car(7, new BMWFactory());
		carService.create(car7);
		carService.create(bmw);
		carService.create(citroen);
		assertSame(carService.readById(7), car7);
	}
	
	@Test
	public void shouldSetCorrectIdForTheSameIdCars() {
		carService.create(citroen);
		carService.create(citroen);
		carService.create(citroen);
		assertThat(carService.getCars().keySet(), hasItems(0,1,2));		
	}
	
}
