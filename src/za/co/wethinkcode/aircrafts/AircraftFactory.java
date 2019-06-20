package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;
import za.co.wethinkcode.aircrafts.Balloon;
import za.co.wethinkcode.aircrafts.Helicopter;
import za.co.wethinkcode.aircrafts.JetPlane;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		if (type.equals("Helicopter"))
			return new Helicopter(name, new Coordinates(longitude, latitude, height));
		else if (type.equals("Balloon"))
			return new Balloon(name, new Coordinates(longitude, latitude, height));
		else if (type.equals("JetPlane"))
			return new JetPlane(name, new Coordinates(longitude, latitude, height));
		return null;
	}
}
