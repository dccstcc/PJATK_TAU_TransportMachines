package pl.edu.pjatk.tau.service;

import java.util.ArrayList;

import pl.edu.pjatk.tau.domain.CarTimestamp;

public interface ISearchingService {

	public ArrayList<String> searchResults = new ArrayList<String>();
	
	public void searchCar(String params);
	public ArrayList<String> getSearch();
	public boolean isSearchEmpty();
	public CarTimestamp parseStringToCar(String carStr);
}
