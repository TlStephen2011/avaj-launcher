package za.co.wethinkcode.weather;

import za.co.wethinkcode.coordinates.Coordinates;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	public void changeWeather() {
		this.conditionsChanged();
	}	
}
