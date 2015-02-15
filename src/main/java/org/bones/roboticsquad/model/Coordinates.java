package org.bones.roboticsquad.model;

import java.util.Hashtable;

public class Coordinates extends Hashtable<String, Hashtable<String, String>> {
	
	private static final long serialVersionUID  = 7526472295622776147L;
	
	public Coordinates() {
		Hashtable<String, String> nDir = new Hashtable<String,String>();
		
		//North
		nDir.put("L", "W");
		nDir.put("R", "E");
		this.put("N", nDir);
		
		//East
		Hashtable<String, String> eDir = new Hashtable<String,String>();
		eDir.put("L", "N");
		eDir.put("R", "S");
		this.put("E", eDir);
		
		//South
		Hashtable<String, String> sDir = new Hashtable<String,String>();
		sDir.put("L", "E");
		sDir.put("R", "W");
		this.put("S", sDir);
		
		//West
		Hashtable<String, String> wDir = new Hashtable<String,String>();
		wDir.put("L", "S");
		wDir.put("R", "N");
		this.put("W", wDir);	
	}
	
	public String getDirection(String currentDirection, String rotation) {
		
		Hashtable<String, String> direction =  this.get(currentDirection);
		return direction.get(rotation).toString();
	}

}
