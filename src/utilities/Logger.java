package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	public static String logFileName = "simulation.txt";
	
	public static boolean logIt(String x) {
		try {
			FileWriter fw = new FileWriter(Logger.logFileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    
			out.println(x);
			out.close();
			return true;
		} catch (IOException ex) {
			System.out.println("Failed to log to file: " + ex.getMessage());
			return false;
		}
	}
}
