package pl.edu.pjatk.tau.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;
import pl.edu.pjatk.tau.domain.factory.BMW.BMWFactory;
import pl.edu.pjatk.tau.domain.factory.Renault.RenaultFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CarTimestamp.class, LocalDateTime.class, TimestampService.class})
public class TimestampServiceTest {
		
	public CarTimestamp cars;
	public TimestampService service;
	
	public Car car;
	public Car car_2;
	
	public Car mockCar = PowerMockito.mock(Car.class);
	public Car mockCar_2 = PowerMockito.mock(Car.class);
	public LocalDateTime mockTime = PowerMockito.mock(LocalDateTime.class);
	public LocalDateTime mockTime_2 = PowerMockito.mock(LocalDateTime.class);
	
	@Test
	public void shouldPass() {
		assertTrue(true);
	}
	
	
	@Test
	public void shouldInitializeAllTimestampsDirectlyAddedIntoDatabase() {
		cars = new CarTimestamp();
		cars.setReadTimestamp(mockTime);
		assertNotNull(cars.getReadTimestamp());
		
		cars.setWriteTimestamp(mockTime);
		assertNotNull(cars.getWriteTimestamp());
		
		cars.setUpdateTimestamp(LocalDateTime.now());
		assertNotNull(cars.getUpdateTimestamp());
	}
	
	@Test
	public void shouldReturnCarWithTimestampAfterCallCreateMethod() {
		service = new TimestampService();
		PowerMockito.when(mockCar.getId()).thenReturn(1);
		service.create(mockCar, mockTime);
		assertNotNull(service.readById(1));
		assertNotNull(service.getCarsTime().get(1));
		assertNotNull(service.getCarsTime().get(1).getWriteTimestamp());
		assertNotNull(service.getCarsTime().get(1).getReadTimestamp());

	}
	
	@Test
	public void shouldReturnCorrectTimestampAfterCallCreateMethod() {
		service = new TimestampService();
		PowerMockito.when(mockTime.getDayOfMonth()).thenReturn(12);
		PowerMockito.when(mockCar.getId()).thenReturn(3);
		service.create(mockCar, mockTime);
		assertNotNull(service.getCarsTime().get(3));
		assertEquals(12, service.getCarsTime().get(3).getWriteTimestamp().getDayOfMonth());
	}
	
	@Test
	public void shouldReturnNullValueAfterAccessToUpdateAndReadTimestamps() {
		service = new TimestampService();
		PowerMockito.when(mockTime.getDayOfMonth()).thenReturn(6);
		PowerMockito.when(mockCar.getId()).thenReturn(1);
		service.create(mockCar, mockTime);
		assertNotNull(service.getCarsTime().get(1));
		assertNull(service.getCarsTime().get(1).getUpdateTimestamp());
		assertNull(service.getCarsTime().get(1).getReadTimestamp());
	}
	
	@Test
	public void shouldReturnAnotherTimestampValueForDifferentCarsObjects() {
		service = new TimestampService();
		
		car = new Car(3, new BMWFactory());
		car_2 = new Car(5, new RenaultFactory());
		
		PowerMockito.when(mockTime.getHour()).thenReturn(3);
		PowerMockito.when(mockTime_2.getHour()).thenReturn(5);

		service.create(car, mockTime);
		service.create(car_2, mockTime_2);
		
		assertNotNull(service.getCarsTime().get(3));
		assertNotNull(service.getCarsTime().get(5));
		assertEquals(3, service.getCarsTime().get(3).getWriteTimestamp().getHour());
		assertEquals(5, service.getCarsTime().get(5).getWriteTimestamp().getHour());

	}
	
	@Test
	public void shouldReturnCarTimestampObjectAfterCallReadByIdMethod() {
		service = new TimestampService();
		
		car = new Car(20, new RenaultFactory());
			
		service.create(car, mockTime);
		
		assertNotNull(service.readById(20).getWriteTimestamp());
	}
	
	@Test
	public void shouldReturnAppropriateCarTimestampObjectAfterCallReadByIdMethod() {
		service = new TimestampService();
		
		car = new Car(10, new RenaultFactory());
		PowerMockito.when(mockTime.getMinute()).thenReturn(30);
		
		service.create(car, mockTime);
		
		assertNotNull(service.readById(10));
		assertEquals(30, service.readById(10).getWriteTimestamp().getMinute());
	}
	
	@Test
	public void shouldReturnSetAppropriateCarTimestampsAfterCallReadByIdMethod() {
		service = new TimestampService();
		
		car = new Car(20, new RenaultFactory());
		PowerMockito.when(mockTime.getDayOfMonth()).thenReturn(1);
		car_2 = new Car(30, new BMWFactory());
		PowerMockito.when(mockTime_2.getDayOfMonth()).thenReturn(7);
		
		service.create(car, mockTime);
		service.create(car_2, mockTime_2);
		
		assertNotNull(service.readById(20));
		assertNotNull(service.readById(30));
		assertEquals(1, service.readById(20).getWriteTimestamp().getDayOfMonth());
		assertEquals(7, service.readById(30).getWriteTimestamp().getDayOfMonth());
	}
	
	@Test
	public void shouldReturnNotNullReadTimestamp() {
		service = new TimestampService();

		car = new Car(5, new RenaultFactory());

		service.create(car, mockTime);
		
		assertNotNull(service.readById(5).getReadTimestamp());
	}
	
	@Test
	public void shouldReturnAppropriateReadTimestamp() {
		service = new TimestampService();

		car = new Car(12, new BMWFactory());

		service.create(car, mockTime_2);
		
		assertEquals(service.actualTime().getSecond(), service.readById(12).getReadTimestamp().getSecond());
	}
	
	@Test
	public void shouldReturnActualReadTimestamp() {
		service = new TimestampService();

		car = new Car(17, new RenaultFactory());

		service.create(car, mockTime);
		
		assertEquals(service.actualTime().getSecond(), service.readById(17).getReadTimestamp().getSecond());
		assertEquals(service.actualTime().getMinute(), service.readById(17).getReadTimestamp().getMinute());
		assertEquals(service.actualTime().getHour(), service.readById(17).getReadTimestamp().getHour());
		assertEquals(service.actualTime().getDayOfWeek(), service.readById(17).getReadTimestamp().getDayOfWeek());
	}
	
	@Test
	public void shouldReturnNotNullValueAfterUpdate() {
		service = new TimestampService();
		
		car = new Car(50, new RenaultFactory());
		
		service.create(car, mockTime);
		assertNotNull(service.readById(50));
		
		car.setMark("forTest");
		service.update(car);
		assertNotNull(service.readById(50));
	}
	
	@Test
	public void shouldReturnAppropriateUpdateTimestampAfterCallUpdateMethod() {
		service = new TimestampService();
		
		car = new Car(25, new BMWFactory());
		
		service.create(car, mockTime);
		
		car.setMark("forTest");
		service.update(car);
		assertEquals("forTest", service.readById(25).getMark());
	}
	
	@Test
	public void shouldReturnAppropriateUpdateTimestampAfterCallMultipleUpdateMethod() {
		service = new TimestampService();
		
		car = new Car(222, new RenaultFactory());
		
		service.create(car, mockTime);
		
		car.setColor("firstTest");
		service.update(car);
		assertEquals("firstTest", service.readById(222).getColor());
		
		car.setColor("secondTest");
		service.update(car);
		assertEquals("secondTest", service.readById(222).getColor());
		
		car.setColor("thirdTest");
		service.update(car);
		assertEquals("thirdTest", service.readById(222).getColor());
	} 
	
	@Test
	public void shouldReturnAppropriateUpdateTimestampValueAfterCallUpdateMethod() {
		service = new TimestampService();
		
		car = new Car(99, new BMWFactory());
		
		service.create(car, mockTime);
		
		car.setProducentCountry("underTest");
		
		service.update(car);
		assertEquals(service.actualTime().getSecond(), service.getCarsTime().get(99).getUpdateTimestamp().getSecond());
		assertEquals(service.actualTime().getMinute(), service.getCarsTime().get(99).getUpdateTimestamp().getMinute());
		assertEquals(service.actualTime().getHour(), service.getCarsTime().get(99).getUpdateTimestamp().getHour());
		assertEquals(service.actualTime().getDayOfMonth(), service.getCarsTime().get(99).getUpdateTimestamp().getDayOfMonth());

	}
	
	@Test
	public void shouldDisableWriteTimestampAndReturnNullValue() {
		service = new TimestampService();
		
		car = new Car(333, new BMWFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(333);
		
		service.disableWriteTS();
		service.create(car, mockTime);
		
		assertNull(service.getCarsTime().get(333).getWriteTimestamp());
	}
	
	@Test
	public void shouldEnableWriteTimestampAndReturnAppriopriateValue() {
		service = new TimestampService();
		
		car = new Car(444, new RenaultFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(444);
		
		service.disableWriteTS();
		service.create(car, mockTime);
				
		assertNull(service.getCarsTime().get(444).getWriteTimestamp());
		
		
		car_2 = new Car(555, new BMWFactory());
		
		service.enableWriteTS();
		service.create(car_2, mockTime);
		
		assertEquals(444, service.getCarsTime().get(555).getWriteTimestamp().getNano());
	}
	
	@Test
	public void shouldDisableUpdateTimestampAndReturnNullValue() {
		service = new TimestampService();
		
		car = new Car(234, new BMWFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(234);
		
		service.disableUpdateTS();
		service.create(car, mockTime);
		
		car.setGearboxType("TEST");
		service.update(car);
		
		assertNull(service.getCarsTime().get(234).getUpdateTimestamp());
	}
	
	@Test
	public void shouldEnableUpdateTimestampAndReturnAppriopriateValue() {
		service = new TimestampService();
		
		car = new Car(4321, new BMWFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(4321);
		
		service.disableUpdateTS();
		service.create(car, mockTime);
		
		car.setGearboxType("TEST");
		service.update(car);
		
		assertNull(service.getCarsTime().get(4321).getUpdateTimestamp());
		
		service.enableUpdateTS();
		car.setGearboxType("#####TEST####");
		service.update(car);
		
		assertEquals(4321, service.getCarsTime().get(4321).getWriteTimestamp().getNano());
	}
	
	@Test
	public void shouldDisableReadTimestampAndReturnNullValue() {
		service = new TimestampService();
		
		car = new Car(998, new RenaultFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(998);
		
		service.disableReadTS();
		service.create(car, mockTime);
		
		assertNull(service.readById(998).getReadTimestamp());
	}
	
	@Test
	public void shouldEnableReadTimestampAndReturnAppriopriateValue() {
		service = new TimestampService();
		
		car = new Car(678, new BMWFactory());
				
		service.disableReadTS();
		service.create(car, mockTime);
		
		assertNull(service.readById(678).getReadTimestamp());
		
		service.enableReadTS();
		
		assertNotNull(service.readById(678).getReadTimestamp());
	}
	
	@Test
	public void shouldDisableAllTimestampsAndReturnNullValue() {
		
		service = new TimestampService();
		
		car = new Car(9876, new BMWFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(9876);
		
		service.disableWriteTS();
		service.disableReadTS();
		service.disableUpdateTS();
		service.create(car, mockTime);
		
		assertNull(service.readById(9876).getWriteTimestamp());
		assertNull(service.readById(9876).getReadTimestamp());
		
		car.setEngineType("TEST");
		service.update(car);
		
		assertNull(service.readById(9876).getUpdateTimestamp());
	}
	
	@Test
	public void shouldEableAllTimestampsAndReturnAppropriateValue() {
		
		service = new TimestampService();
		
		car = new Car(3210, new BMWFactory());
		
		PowerMockito.when(mockTime.getNano()).thenReturn(3210);
		
		service.disableWriteTS();
		service.disableReadTS();
		service.disableUpdateTS();
		service.create(car, mockTime);
		
		assertNull(service.readById(3210).getWriteTimestamp());
		assertNull(service.readById(3210).getReadTimestamp());
		
		car.setEngineType("TEST");
		service.update(car);
		
		assertNull(service.readById(3210).getUpdateTimestamp());
		
		
		
		service.enableWriteTS();
		service.enableReadTS();
		service.enableUpdateTS();
		
		car_2 = new Car(54321, new BMWFactory());
		
		PowerMockito.when(mockTime.getMinute()).thenReturn(54321);
		
		service.create(car_2, mockTime);
		
		assertNotNull(service.readById(54321).getWriteTimestamp());
		assertNotNull(service.readById(54321).getReadTimestamp());
		
		car_2.setEngineType("TEST");
		service.update(car_2);
		
		assertNotNull(service.readById(54321).getUpdateTimestamp());
		
		assertEquals(54321, service.readById(54321).getWriteTimestamp().getMinute());
		
	}
}
