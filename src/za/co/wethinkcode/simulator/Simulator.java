package za.co.wethinkcode.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import za.co.wethinkcode.aircrafts.AircraftFactory;
import za.co.wethinkcode.aircrafts.Flyable;
import za.co.wethinkcode.weather.WeatherTower;

public class Simulator {
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.out.println("Invalid scenario filename");
			return;
		}
				
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<Flyable> aircrafts = new ArrayList<Flyable>();
		
		try {			
			BufferedReader objReader = null;
			objReader = new BufferedReader(new FileReader(args[0]));
		
			while (true) {
				String temp = objReader.readLine();
				if (temp == null) {
					break;
				}
				lines.add(temp);
			}
			
			objReader.close();
			
			Iterator<String> it = lines.iterator();		
			
			int cycles = Integer.parseInt(it.next());
			
			if (cycles < 0) {
				System.out.println("Invalid simulation cycles");
				return;
			}
			
			for (int i = 1; i < lines.size(); i++) {
				String [] splitString = it.next().split(" ");
				
				if (splitString.length != 5) {
					System.out.println("Invalid scenario file");
					return;
				}
				
				String [] tempArr = Arrays.copyOfRange(splitString, 2, 5);
				
				for (String string : tempArr) {
					if (string.matches("[0-9]+")) {
						continue;
					} else {
						System.out.println("Coordinates must be integers");
						return;
					}
				}
				
				int lon, lat, height;
				
				lon = Integer.parseInt(splitString[2]);
				lat = Integer.parseInt(splitString[3]);
				height = Integer.parseInt(splitString[4]);				
				
				if (lon < 0 || lat < 0 || height < 0 || height > 100) {
					System.out.println("Invalid coordinates");
					return;
				}
				
				aircrafts.add(AircraftFactory.newAircraft(splitString[0], splitString[1], lon, lat, height));				
			}
			
			WeatherTower tower = new WeatherTower();

			for (Flyable flyable : aircrafts) {
				flyable.registerTower(tower);
			}
			
			for (int i = 0; i < cycles; i++) {
				tower.changeWeather();
			}
			
		} catch (Exception e) {
			System.out.println("An error has occurred: " + e.getMessage());
		}			
	}
}
