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
		return new Robot(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), coords[2], plateau);
	}
	
	public void processCommands(String command) {
		char[] cmds = command.toCharArray();
		
		for(char cmd : cmds) {
			if (cmd == 'M') {
				move();
			} else if (cmd == 'L'|| cmd == 'R') {
				rotate(String.valueOf(cmd));
			}
		}
		
	}
	
	public void rotate(String rotation) {
		this.direction = this.plateau.getCoords().getDirection(this.direction, rotation);
	}
	
	public void move() {
		
		if (direction.contentEquals("N") && plateau.isValidY(yCoord + 1)) {
				yCoord++;
				return;
		}
		if (direction.contentEquals("E")  && plateau.isValidX(xCoord + 1)) {
				xCoord++;
				return;
		}
		if (direction.contentEquals("S") && plateau.isValidY(yCoord - 1)) {
				yCoord--;
				return;
		}
		if (direction.contentEquals("W") && plateau.isValidX(xCoord - 1)) {
				xCoord--;		
		}
	}
	

	

}
