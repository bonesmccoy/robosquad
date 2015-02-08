package org.bones.models;

import java.util.Hashtable;
import java.util.List;

public class Plateau {
	
	Integer xCorner;
	Integer yCorner;
	
	
	public static Plateau createFromString(String command)
	{
		String[] coords = command.split(" ");
		return new Plateau(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
	}
	
	public Plateau(Integer xCorner, Integer yCorner) {
		this.xCorner = xCorner;
		this.yCorner = yCorner;
	}
	
	public boolean isValidLocation(Integer x, Integer y) {
		return isValidX(x) && isValidY(y);
	}
	
	public boolean isValidX(Integer x) {
		return (x >= 0 && x <= xCorner);
	}
	
	public boolean isValidY(Integer y) {
		return (y >=0 && y <= yCorner);
	}
	
	

}
