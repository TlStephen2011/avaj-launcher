package za.co.wethinkcode.aircrafts;

import coordinates.Coordinates;
import utilities.Logger;
import za.co.wethinkcode.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateConditions() {
		// TODO get the weather
		
		//TODO react to the weather

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Logger.logIt("Helicopter#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");
	}

}
