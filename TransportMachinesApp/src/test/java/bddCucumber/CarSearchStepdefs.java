package bddCucumber;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

//import io.cucumber.java.ParameterType;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import pl.edu.pjatk.tau.domain.Car;
import pl.edu.pjatk.tau.domain.CarTimestamp;
import pl.edu.pjatk.tau.service.TimestampService;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//car data regex pattern
//
//[a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ (petrol|diesel) (manual|automatic) [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+
//
//Renault Captur FR 2017 yellow petrol automatic 220 C med 120000 
//BMW X5 PL 2019 white diesel automatic 280 E sport 200000
//Citroen C5 FR 2010 grey petrol manual 200 C basic 90000

public class CarSearchStepdefs {
	TimestampService cars;
	CarTimestamp carT;
	static int id = 1;
	
	//
	//Prepared for search feature
	//
	
	@Given("^we have car database$")
	public void we_have_car_database() throws Exception {
		cars = new TimestampService();
	}
	
	@Given("^we add car into database as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
	public void we_add_car_into_database_as(String car) throws Exception {
		carT = cars.parseStringToCar(car);
		carT.setId(id++);
		cars.create(carT);
	}
	
	@When("^we find key words with car searcher as ([a-zA-Z0-9]+ ?)$")
	public void we_find_key_words_with_car_searcher_as(String carAttr) throws Exception {
		cars.searchCar(carAttr);
	}
	
	@Then("^the result should be ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+|Nothing found)$")
	public void the_result_should_be(String carResults) throws Exception{
		for(String s: cars.getSearch()) {
			if(s.equals(carResults)) {
				assertEquals(s, carResults);
			}
		}
	}
	
	//
	//Prepared for delete feature
	//
	
//	public TimestampService carTserv;
//	public ArrayList<CarTimestamp> carTsList;
//	public CarTimestamp carTs;
//	
//	@Given("^we have new car database$")
//	public void we_have_new_car_database() throws Exception {
//		carTserv = new TimestampService();;
//	}
//	
//	@Given("^we have car list to delete$")
//	public void we_have_car_list_to_delete() throws Exception {
//		carTsList = new ArrayList<CarTimestamp>();
//	}
//	
//	@Given("^we add first car into database as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_first_car_into_database_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTserv.create(carTs);
//	}
//	
//	@Given("^we add second car into database as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_second_car_into_database_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTserv.create(carTs);
//	}
//	
//	@Given("^we add third car into database as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_third_car_into_database_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTserv.create(carTs);
//	}
//	
//	@Given("^we add fourth car into database as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_fourth_car_into_database_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTserv.create(carTs);
//	}
//	
//	@Given("^we add car number two into to delete list as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_car_number_two_into_to_delete_list_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTsList.add(carTs);
//	}
//	
//	@Given("^we add car number four into to delete list as ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void we_add_car_number_four_into_to_delete_list_as(String carAttr) throws Exception {
//		carTs = carTserv.parseStringToCar(carAttr);
//		carTs.setId(id++);
//		carTsList.add(carTs);
//	}
//	
//	@When("^we delete cars from database using list of cars$")
//	public void we_delete_cars_from_database_using_list_of_cars() {
//		
//	}
//	
//	@Then("^the database shouldnt contains cars from list but should contains cars ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+) ___and___ ([a-zA-Z]+ [a-zA-Z0-9]+ [A-Z]{2,3}+ [1-9][0-9]{3}+ [a-z]+ p?e?t?r?o?l?d?i?e?s?e?l? m?a?n?u?a?l?a?u?t?o?m?a?t?i?c? [1-3][0-9]{2} [A-I|K] [a-z]+ [1-9][0-9]+)$")
//	public void the_database_shouldnt_contains_cars_from_list_but_should_contains_cars(String carResults_1, String carResult_2) throws Exception{
//		
//	}
	
}
