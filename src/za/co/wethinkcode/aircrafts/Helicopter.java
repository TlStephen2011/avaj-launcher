package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.utilities.Logger;
import za.co.wethinkcode.weather.WeatherProvider;
import za.co.wethinkcode.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
		
		//TODO: proper log messages
		
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		
		if (weather.equals("RAIN")) {
			Coordinates x = new Coordinates(lon + 5,
											lat,
											height);
			Logger.logIt("Raining");
			this.coordinates = x;
		} else if (weather.equals("SNOW")) {
			Coordinates x = new Coordinates(lon,
											lat,
											height - 12 < 0 ? 0 : height - 12);
			Logger.logIt("Brrrrr, snowy");
			this.coordinates = x;
		} else if (weather.equals("SUN")) {
			Coordinates x = new Coordinates(lon + 10,
											lat,
											height + 2 > 100 ? 100 : height + 2);
			Logger.logIt("Sunny");
			this.coordinates = x;
		} else if (weather.equals("FOG")) {
			Coordinates x = new Coordinates(lon + 1,
											lat,
											height);
			Logger.logIt("Foggy");
			
			this.coordinates = x;
		}
		
		if (this.coordinates.getHeight() == 0) {
			Logger.logIt("Unregistering from tower");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Logger.logIt("Helicopter#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");
	}

}
