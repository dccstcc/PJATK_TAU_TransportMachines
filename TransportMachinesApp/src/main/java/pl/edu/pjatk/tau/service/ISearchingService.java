package pl.edu.pjatk.tau.service;

import pl.edu.pjatk.tau.domain.CarTimestamp;

public interface ISearchingService {

	public String searchResults = "";
	
	public void searchCar(String params);
	public String getSearch();
	public boolean isSearchEmpty();
	public CarTimestamp parseStringToCar(String carStr);
}
