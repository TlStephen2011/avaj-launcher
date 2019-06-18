package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		// TODO: return appropriate new aircraft
		return new Helicopter(name, new Coordinates(longitude, latitude, height));
	}
}
