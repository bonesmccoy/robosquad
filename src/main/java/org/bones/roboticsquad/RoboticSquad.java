package org.bones.roboticsquad;

import org.bones.models.Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.List;

import org.bones.models.Plateau;

public class RoboticSquad {
	
	List<String> commands;
	Plateau plateau;
	List<Robot> robots;
	Hashtable<String, Hashtable> coords;

	public static void main(String[] args) {
		
		if (args.length < 1 ) {
			System.out.println("Usage:\r robosquad -inputfile");
			System.exit(0);
		}
		
		try {
			Path filePath = Paths.get(args[0]);
			List<String> commands = Files.readAllLines(filePath, Charset.forName("UTF-8"));
			RoboticSquad rSquad = new RoboticSquad(commands);
			rSquad.processLines();
			
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);
		}
	
	}
	
	public RoboticSquad(List<String> commands) {
		this.commands = commands;
		
	}
	
	public void createCoords() {
		
		this.coords = new Hashtable<String,Hashtable>();
		Hashtable<String, String> nDir = new Hashtable<String,String>();
		
		//North
		nDir.put("L", "W");
		nDir.put("R", "E");
		this.coords.put("N", nDir);
		
		//East
		Hashtable<String, String> eDir = new Hashtable<String,String>();
		eDir.put("L", "N");
		eDir.put("R", "S");
		this.coords.put("E", eDir);
		
		//South
		Hashtable<String, String> sDir = new Hashtable<String,String>();
		sDir.put("L", "E");
		sDir.put("R", "W");
		this.coords.put("S", sDir);
		
		//West
		Hashtable<String, String> wDir = new Hashtable<String,String>();
		wDir.put("L", "S");
		wDir.put("R", "N");
		this.coords.put("W", wDir);	
	}
	
	public void processLines() {
		
		plateau = Plateau.createFromString(this.commands.get(0));
		this.commands.remove(0);
		Integer iteration;
		
		for (string command:this.commands) {
			
			
			
		}
	}

	public List<String> getCommands() {
		return commands;
	}

	}
