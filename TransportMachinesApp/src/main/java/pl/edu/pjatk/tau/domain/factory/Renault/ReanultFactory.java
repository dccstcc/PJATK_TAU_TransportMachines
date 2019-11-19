package pl.edu.pjatk.tau.domain.factory.Renault;

import pl.edu.pjatk.tau.domain.factory.CarFactory;
import pl.edu.pjatk.tau.domain.factory.CustomerData;
import pl.edu.pjatk.tau.domain.factory.ProducentData;
import pl.edu.pjatk.tau.domain.factory.TechnicalData;

public class ReanultFactory implements CarFactory {
		
	public ProducentData createProducentData() {
		ProducentData pd = new RenaultProducentData();
		car.setMark(pd.getProducentData().getMark());
		car.setModel(pd.getProducentData().getModel());
		car.setProducentCountry(pd.getProducentData().getProducentCountry());
		car.setYearOfProduction(pd.getProducentData().getYearOfProduction());
		return pd;
	}
	public TechnicalData createTechnicalData() {
		TechnicalData td = new RenaultTechnicalData();
		car.setEngineType(td.getTechnicalData().getEngineType());
		car.setGearboxType(td.getTechnicalData().getGearboxType());
		car.setMaxSpeed(td.getTechnicalData().getMaxSpeed());
		return td;
	}
	public CustomerData createCustomerData() {
		CustomerData cd = new RenaultCustomerData();
		car.setColor(cd.getCustomerData().getColor());
		car.setSegmentType(cd.getCustomerData().getSegmentType());
		car.setProductVersion(cd.getCustomerData().getProductVersion());
		car.setPrice(cd.getCustomerData().getPrice());
		return cd;
	}
}
