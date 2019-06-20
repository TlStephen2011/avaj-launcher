package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.utilities.Logger;
import za.co.wethinkcode.weather.WeatherProvider;
import za.co.wethinkcode.weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Balloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);		
		String formattedName = "Balloon#" + this.name + "(" + this.id + "): ";
		
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (weather.equals("RAIN")) {
			Coordinates x = new Coordinates(lon,
					lat,
					height - 5 < 0 ? 0 : height - 5);
			Logger.logIt(formattedName + "damn this rain, I need another balloon");
			this.coordinates = x;
		} else if (weather.equals("SNOW")) {
			Coordinates x = new Coordinates(lon,
					lat,
					height - 15 < 0 ? 0 : height - 15);
			Logger.logIt(formattedName + "my balloon is going nowhere with this snow");
			this.coordinates = x;
		} else if (weather.equals("SUN")) {
			Coordinates x = new Coordinates(lon + 2,
					lat,
					height + 4 > 100 ? 100 : height + 4);
			Logger.logIt(formattedName + "it's so sunny my balloon will go to the moon");
			this.coordinates = x;
		} else if (weather.equals("FOG")) {
			Coordinates x = new Coordinates(lon,
					lat + 1,
					height - 3 < 0 ? 0 : height - 3);
			Logger.logIt(formattedName + "so foggy, cant see the balloon");

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
		Logger.logIt("Balloon#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");
	}

}
