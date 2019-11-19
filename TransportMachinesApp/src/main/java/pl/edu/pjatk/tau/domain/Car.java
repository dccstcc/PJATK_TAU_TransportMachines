package pl.edu.pjatk.tau.domain;

import pl.edu.pjatk.tau.domain.factory.CarFactory;
import pl.edu.pjatk.tau.domain.factory.CustomerData;
import pl.edu.pjatk.tau.domain.factory.ProducentData;
import pl.edu.pjatk.tau.domain.factory.TechnicalData;

public class Car {
	
	private int id;
	private String mark;
	private String model;
	private String producentCountry;
	private int yearOfProduction;
	private String color;
	private String engineType;
	private String gearboxType;
	private int maxSpeed;
	private String segmentType;
	private String productVersion;
	private int price;
	
	public Car() {
		
	}
	
	public Car(int id, CarFactory f) {
		
		this.id = id;
		
		ProducentData pd = f.createProducentData();
		TechnicalData td = f.createTechnicalData();
		CustomerData cd = f.createCustomerData();
		
		mark = pd.getProducentData().mark;
		model = pd.getProducentData().model;
		producentCountry = pd.getProducentData().producentCountry;
		yearOfProduction = pd.getProducentData().yearOfProduction;
		
		engineType = td.getTechnicalData().engineType;
		gearboxType = td.getTechnicalData().gearboxType;
		maxSpeed = td.getTechnicalData().maxSpeed;
		
		color = cd.getCustomerData().color;
		segmentType = cd.getCustomerData().segmentType;
		productVersion = cd.getCustomerData().productVersion;
		price = cd.getCustomerData().price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProducentCountry() {
		return producentCountry;
	}
	public void setProducentCountry(String producentCountry) {
		this.producentCountry = producentCountry;
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getGearboxType() {
		return gearboxType;
	}
	public void setGearboxType(String gearboxType) {
		this.gearboxType = gearboxType;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getSegmentType() {
		return segmentType;
	}
	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
