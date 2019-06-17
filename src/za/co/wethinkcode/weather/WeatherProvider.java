package za.co.wethinkcode.weather;

import coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private String[] weather;
	
	private WeatherProvider() {}
	
	public static WeatherProvider getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		//TODO: Determine weather based on coordinates somehow and push to weather array
		return "Weather info is temporarily unavailable";
	}
}
