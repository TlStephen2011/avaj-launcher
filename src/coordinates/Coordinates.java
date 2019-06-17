package coordinates;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	public Coordinates(int longitude, int latitude, int altitude) {
		this.longitude = longitude;
		this.height = altitude;
		this.latitude = latitude;
	}
	
	public int getLongitude() {
		return this.longitude;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public int getHeight() {
		return this.height;
	}
	
}
