package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.utilities.Logger;
import za.co.wethinkcode.weather.WeatherProvider;
import za.co.wethinkcode.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	
	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
		
		//TODO: check height constraint values and proper log messages
		if (weather.equals("RAIN")) {
			Coordinates x = new Coordinates(this.coordinates.getLongitude(),
											this.coordinates.getLatitude(),
											this.coordinates.getHeight() - 5);
			Logger.logIt("Raining");
			this.coordinates = x;
		} else if (weather.equals("SNOW")) {
			Coordinates x = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
			Logger.logIt("Brrrrr, snowy");
			this.coordinates = x;
		} else if (weather.equals("SUN")) {
			Coordinates x = new Coordinates(this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4);
			Logger.logIt("Sunny");
			this.coordinates = x;
		} else if (weather.equals("FOG")) {
			Coordinates x = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 3);
			Logger.logIt("Foggy");
			this.coordinates = x;
		}
		
		if (this.coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
		}
		
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
		Logger.logIt("JetPlane#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");		
	}

}
