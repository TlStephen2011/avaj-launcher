package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {

	public Balloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		// TODO Auto-generated method stub

	}

}