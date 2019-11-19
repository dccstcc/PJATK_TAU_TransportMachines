package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.Car;
//import pl.edu.pjatk.tau.service.*;

import java.util.TreeMap;

import org.junit.BeforeClass;
import org.junit.Ignore;
//import org.hamcrest.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarServiceTest {
	
	public static CarService carService;
	
	@BeforeClass
	public static void initCarServiceClass() {
		carService = new CarService();
	}
	
	@Test
	public void ShouldInitializeEmptyDatabase() {
		TreeMap<Integer, Car> db = new CarDb().getDb();
		assertNotNull(db);
	}

	@Test
	public void ShouldReturnCarOfKnownId() {
		//CarService carService = new CarService();
		assertNotNull(carService.readById(1));
	}

}
