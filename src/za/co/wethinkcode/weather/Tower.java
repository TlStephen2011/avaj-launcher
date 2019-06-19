package za.co.wethinkcode.weather;

import java.util.ArrayList;
import java.util.Iterator;

import za.co.wethinkcode.aircrafts.Flyable;
import za.co.wethinkcode.utilities.Logger;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {		
		for (Flyable aircraft : this.observers) {
			if (flyable == aircraft) {
				//TODO: update logged text
				Logger.logIt("Landed");
				this.observers.remove(aircraft);
				break;
			}
		}
	}
	
	protected void conditionsChanged() {
		ArrayList<Flyable> temp = new ArrayList<Flyable>(observers);
		for (Flyable f : temp) {
			if (observers.contains(f)) {
				f.updateConditions();
			}
		}
	}
}
