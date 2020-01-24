package cucumber;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;
import pl.edu.pjatk.tau.service.TimestampService;

public class CarStepdefs {
	TimestampService cars;
	CarTimestamp carT;
	int id = 0;
	
	@Given("^we have car database$")
	public void we_have_car_database() throws Exception {
		cars = new TimestampService();;
	}
	
	@Given("^we add car into database as (regex)")
	public void we_add_car_into_datanase_as(String car) throws Exception {
		carT = cars.parseStringToCar(car);
		carT.setId(id++);
		cars.create(carT);
	}
	
	@When("we find key words with car searcher as (regex)")
	public void we_find_key_words_with_car_searcher_as(String carAttr) throws Exception {
		cars.searchCar(carAttr);
	}
	
	@Then("the result should be (regex)")
	public void the_result_should_be(String carResults) {
		assertEquals(cars.getSearch(), carResults);
	}
	
	
}
