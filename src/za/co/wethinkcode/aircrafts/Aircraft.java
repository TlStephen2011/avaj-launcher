package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.coordinates.Coordinates;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	private static long idCounter = 12345;
	protected Aircraft(String name, Coordinates coordinates) {
		this.coordinates = coordinates;
		this.name = name;
		this.id = Aircraft.nextId();
	}
	
	private static long nextId() {
		return ++Aircraft.idCounter;
	}
}
