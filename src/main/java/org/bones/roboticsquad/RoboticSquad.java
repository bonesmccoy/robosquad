package org.bones.roboticsquad;

import org.bones.models.Robot;

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
	Hashtable<Integer, Robot> robots;

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
		this.robots = new Hashtable<Integer, Robot>();
	}
	

	public void processLines() {
		
		plateau = Plateau.createFromString(this.commands.get(0));
		this.commands.remove(0);
		Integer iteration = 0;
		Integer robotIndex = 0;
		
		for(String line : commands) {
			if ((iteration % 2) == 1) {
				Robot rob = robots.get(robotIndex);
				rob.processCommands(line);
				System.out.println(rob.getPosition());
			} else {
				Robot rob = Robot.createFromCommand(line, plateau);
				robotIndex++;
				this.robots.put(robotIndex, rob);
			}
			iteration++;
		}
	}

	public List<String> getCommands() {
		return commands;
	}

}
