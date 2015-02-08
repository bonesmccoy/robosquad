package org.bones.models;

public class Robot {
	
	String direction;
	Integer xCoord;
	Integer yCoord;
	Plateau plateau;
	
	
	public Robot(Integer xCoord, Integer yCoord, String direction, Plateau plateau) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.direction = direction;
		this.plateau = plateau;
	}
	
	public String getPosition(){
		return this.xCoord.toString() + " " + this.yCoord.toString() + " " + this.direction;
	}

	public static Robot createFromCommand(String command, Plateau plateau) {
		
		String[] coords = command.split(" ");
		return new Robot(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), coords[3], plateau);
	}
	
	public void move(String command) {
		char[] cmd = command.toCharArray();
		
	}
	
	public void rotate(String direction) {
		
		String newDirection = this.direction;
		switch(this.direction) {
		case 'N': {
			if (direction == "L")  { newDirection = "W"; }
			else if (direction == "R") {newDirection = "E";}
		}
		break
			
		}
	}
	

	

}
