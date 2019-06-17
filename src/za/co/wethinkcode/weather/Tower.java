package za.co.wethinkcode.weather;

import java.util.List;
import za.co.wethinkcode.aircrafts.Flyable;

public abstract class Tower {
	private List<Flyable> observers;
	
	public void register(Flyable flyable) {
		//TODO: add flyable to observers list
	}
	
	public void unregister(Flyable flyable) {
		//TODO: remove flyable from observers
	}
	
	protected void conditionsChanged() {
		//TODO: update all observers
	}
}
