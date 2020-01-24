package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pl.edu.pjatk.tau.domain.CarTimestamp;

public class CarStepdefs {
	CarTimestamp cars;
	
	@Given("^we have car database$")
	public void we_have_car_database() throws Exception {
		cars = new CarTimestamp();
	}
	
	@When("we find key words with car searcher as (regex)")
	public void we_find_key_words_with_car_searcher_as(String carAttr) throws Exception {
		
	}
	
	@Then("the result should be (regex)")
	public void the_result_should_be(String carResults) {
		
	}
	
	
}
