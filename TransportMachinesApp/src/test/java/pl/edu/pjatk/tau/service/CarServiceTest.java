package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.factory.BMW.BMWFactory;
import pl.edu.pjatk.tau.domain.factory.Citroen.CitroenFactory;
import pl.edu.pjatk.tau.domain.factory.Renault.RenaultFactory;

import java.util.NoSuchElementException;
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
	public void initTestObject() {
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
	public void shouldSetCorrectIdForTheCarsWithSameIdIntoCarsObjects() {
		carService.create(citroen);
		assertEquals(1, carService.readById(1).getId());

		carService.create(citroen);
		assertEquals(0, carService.readById(0).getId());
		
		carService.create(citroen);
		assertEquals(2, carService.readById(2).getId());	
	}
	
	@Test
	public void shouldNotModifyFieldsOfAddedCar() {
		carService.create(bmw);
		assertEquals("X3", carService.readById(0).getModel());
		carService.create(citroen);
		assertEquals("Automatic", carService.readById(1).getGearboxType());
		carService.create(renault);
		assertEquals(65000, carService.readById(2).getPrice());
	}
	
	@Test
	public void shouldSetCorrectIdForTheCarsWithSameIdIntoDatabase() {
		carService.create(renault);
		carService.create(renault);
		carService.create(renault);
		assertThat(carService.getCars().keySet(), hasItems(0,1,2));		
	}

	@Test
	public void shouldThrowExceptionIfCollectionIsEmpty() {
		exception.expect(NullPointerException.class);
		carService.readAll();
	}
	
	@Test
	public void shouldReturnAllAddedCars() {
		carService.create(bmw);
		carService.create(renault);
		carService.create(renault);
		carService.create(citroen);
		assertEquals(4, carService.readAll().size());
	}
	
	@Test
	public void shouldReturnDatabaseWithNotModifiedCars() {
		carService.create(citroen);
		carService.create(bmw);
		carService.create(renault);
		carService.create(bmw);
		assertEquals("BMW", carService.readAll().get(0).getMark());
		assertEquals("Diesel", carService.readAll().get(0).getEngineType());
		assertEquals("Citroen", carService.readAll().get(1).getMark());
		assertEquals("Petrol", carService.readAll().get(1).getEngineType());
		assertEquals("Renault", carService.readAll().get(2).getMark());
		assertEquals("C", carService.readAll().get(2).getSegmentType());
		assertEquals("BMW", carService.readAll().get(3).getMark());
		assertEquals("White", carService.readAll().get(3).getColor());		
	}
	
	@Test
	public void shouldThrowExceptionIfCarDoNotExist() {
		exception.expect(NoSuchElementException.class);
		carService.create(bmw);
		carService.update(citroen);
	}
	
	@Test
	public void shouldThrowExceptionIfUpdateCarOnEmptyDatabase() {
		exception.expect(NullPointerException.class);
		carService.update(renault);
	}
	
	@Test
	public void shouldUpdateCarWithTheSameId() {
		carService.create(bmw);
		assertEquals(90000, carService.readAll().get(0).getPrice());
		bmw = carService.readById(0);
		
		bmw.setPrice(75000);
		carService.update(bmw);
		
		assertEquals(75000, carService.readAll().get(0).getPrice());
	}
	
	@Test
	public void shouldUpdateCarWithoutChangeDefaultFields() {
		carService.create(citroen);
		assertEquals("C5", carService.readAll().get(1).getModel());
		citroen = carService.readById(1);
		
		citroen.setModel("C4 Cactus");
		carService.update(citroen);
		
		assertEquals("C4 Cactus", carService.readAll().get(1).getModel());
		assertEquals("Automatic", carService.readAll().get(1).getGearboxType());
		assertEquals(260, carService.readAll().get(1).getMaxSpeed());
	}
	
	@Test
	public void shouldThrowExceptionIfCarIdsAreDifferent() {
		exception.expect(NoSuchElementException.class);
		carService.create(renault);
		Car bmw_4 = new Car(4, new BMWFactory());
		carService.update(bmw_4);
	}
	
	@Test
	public void shouldChangeOnUpdateCarWithTheSameId() {
		carService.create(renault);
		assertEquals("Renault", carService.readAll().get(2).getMark());
		carService.create(bmw);
		bmw = carService.readById(0);
		
		bmw.setId(2);
		carService.update(bmw);
		
		assertEquals("BMW", carService.readAll().get(2).getMark());
		assertEquals("BMW", carService.readAll().get(0).getMark());
	}
}
