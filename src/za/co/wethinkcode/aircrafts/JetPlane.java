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

	public void updateConditions() {
		String weather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
		String formattedName = "JetPlane#" + this.name + "(" + this.id + "): ";

		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if (weather.equals("RAIN")) {
			Coordinates x = new Coordinates(lon,
					lat + 5,
					height);
			Logger.logIt(formattedName + "my jetPlane doesn't care about this weak rain");
			this.coordinates = x;
		} else if (weather.equals("SNOW")) {
			Coordinates x = new Coordinates(lon,
					lat,
					height - 7 < 0 ? 0 : height - 7);
			Logger.logIt(formattedName + "damn I got snow on my wing");
			this.coordinates = x;
		} else if (weather.equals("SUN")) {
			Coordinates x = new Coordinates(lon,
					lat + 10,
					height + 2 > 100 ? 100 : height + 2);
			Logger.logIt(formattedName + "so sunny, too bad I'm not a solar plane");
			this.coordinates = x;
		} else if (weather.equals("FOG")) {
			Coordinates x = new Coordinates(lon,
					lat + 1,
					height);
			Logger.logIt(formattedName + "where th f*** am I, cant see anything in this fog");

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
		Logger.logIt("JetPlane#" + this.name + "(" + this.id + "): Has successfully registered to the weather tower.");		
	}

}
