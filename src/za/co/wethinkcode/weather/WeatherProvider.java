package za.co.wethinkcode.weather;

import java.util.Arrays;
import java.util.Random;

import za.co.wethinkcode.coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private String[] weather = new String[1];
	
	private WeatherProvider() {}
	
	public static WeatherProvider getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		String[] newWeatherArray;
		if (this.weather.length != 0)
			newWeatherArray = Arrays.copyOf(weather, weather.length + 1);
		else
			newWeatherArray = new String[1];
		
		Random rand = new Random();
		int lon = coordinates.getLongitude() * (rand.nextInt(10) + 1);
		int lat = coordinates.getLatitude() * (rand.nextInt(10) + 1);
		int height = coordinates.getHeight() * (rand.nextInt(10) + 1);
		
		String [] conditions = new String[] {"SNOW", "RAIN", "SUN", "FOG"};
		int randValue = (lon + lat + height) % 4;
		newWeatherArray[weather.length] = conditions[randValue];
		weather = newWeatherArray;
		return weather[weather.length - 1];
	}
}
