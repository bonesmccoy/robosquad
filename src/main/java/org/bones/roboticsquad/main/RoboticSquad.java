package org.bones.roboticsquad.main;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.List;

import org.bones.roboticsquad.model.Plateau;
import org.bones.roboticsquad.model.Robot;

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
		
		Integer robotIndex = 0;
		Integer i;
		for (i = 0; i < this.commands.size(); i++) {
			try {
				String robDefinition = this.commands.get(i);
				String instructionList = this.commands.get(++i);
				Robot rob = Robot.createFromCommand(robDefinition, plateau);
				rob.setInstructionList(instructionList);
	     		(new Thread(rob)).start();
				this.robots.put(robotIndex++, rob);
			} catch(Exception e) {
				
			}
		}
		
	}

	public List<String> getCommands() {
		return commands;
	}

}
