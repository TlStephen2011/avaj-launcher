package za.co.wethinkcode.weather;

import java.util.ArrayList;
import za.co.wethinkcode.aircrafts.Flyable;
import za.co.wethinkcode.utilities.Logger;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		for (Flyable aircraft : observers) {
			if (flyable.equals(aircraft)) {
				//TODO: update logged text
				Logger.logIt("Landed");
				this.observers.remove(aircraft);
			}
		}
	}
	
	protected void conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}
