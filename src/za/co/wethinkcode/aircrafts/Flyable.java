package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.weather.WeatherTower;

public interface Flyable {
	public void updateConditions();
	
	public void registerTower(WeatherTower weatherTower);
}
