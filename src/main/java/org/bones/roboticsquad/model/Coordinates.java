package org.bones.roboticsquad.model;

import java.util.ArrayList;
import java.util.Hashtable;

public class Coordinates extends Hashtable<String, Hashtable<String, String>> {
	
	private static final long serialVersionUID  = 7526472295622776147L;
	
	ArrayList<String> coordinates;
	Hashtable<String, Integer> rotations; 
	
	public Coordinates() {
		coordinates = new ArrayList<String>();
		coordinates.add(0, "N");
		coordinates.add(1, "E");
		coordinates.add(2, "S");
		coordinates.add(3, "W");
		
		rotations = new Hashtable<String, Integer>();
		rotations.put("L", -1);
		rotations.put("R", 1);
	}
	
	public String getDirection(String currentDirection, String rotation) {
		
		Integer direction = coordinates.indexOf(currentDirection);
		Integer newDirection = ((direction + rotations.get(rotation)) % 4);
		newDirection = (newDirection < 0) ? newDirection + 4 : newDirection;
		return coordinates.get(newDirection);
	}

}
