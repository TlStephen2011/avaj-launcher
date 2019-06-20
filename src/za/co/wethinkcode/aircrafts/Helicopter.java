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
		String formattedName = "Helicopter#" + this.name + "(" + this.id + "): ";
		
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		
		if (weather.equals("RAIN")) {
			Coordinates x = new Coordinates(lon + 5,
											lat,
											height);
			Logger.logIt(formattedName + "my rotor is getting wet");
			this.coordinates = x;
		} else if (weather.equals("SNOW")) {
			Coordinates x = new Coordinates(lon,
											lat,
											height - 12 < 0 ? 0 : height - 12);
			Logger.logIt(formattedName + "can't stay up here for long with this snow");
			this.coordinates = x;
		} else if (weather.equals("SUN")) {
			Coordinates x = new Coordinates(lon + 10,
											lat,
											height + 2 > 100 ? 100 : height + 2);
			Logger.logIt(formattedName + "won't be needing assistance from tower today, skies clear");
			this.coordinates = x;
		} else if (weather.equals("FOG")) {
			Coordinates x = new Coordinates(lon + 1,
											lat,
											height);
			Logger.logIt(formattedName + "I think I'm lost tower, help please");			
			this.coordinates = x;
		}

        lon = this.coordinates.getLongitude();
        lat = this.coordinates.getLatitude();
        height = this.coordinates.getHeight();

		if (this.coordinates.getHeight() == 0) {
			Logger.logIt(formattedName + "is landing at (" + lon + ", " + lat + ", " + height + ")");
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Logger.logIt("Helicopter#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");
	}

}
