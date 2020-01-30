package pl.edu.pjatk.tau.service;

import java.util.ArrayList;

import pl.edu.pjatk.tau.domain.CarTimestamp;

public interface IDeleteService {

	public ArrayList<CarTimestamp> toDeleteCars = new ArrayList<CarTimestamp>();
	
	public ArrayList<CarTimestamp> getDelList();
	public int deleteFromList(ArrayList<CarTimestamp> toDeleteList);
}
