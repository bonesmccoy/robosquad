package org.bones.roboticsquad;


import java.util.logging.Logger;

import junit.framework.Assert;

import org.bones.roboticsquad.model.Plateau;
import org.bones.roboticsquad.model.Robot;
import org.junit.Test;

public class RobotTest {

	@Test
	public void testRobotCreation() {
		
		Plateau plateau = new Plateau(10, 10);
		Robot rob = new Robot(2, 2, "E", plateau);
		
		Assert.assertTrue(rob.getPosition().equals("2 2 E"));
	}
	
	@Test
	public void testRobotMove() {
		
		Plateau plateau = new Plateau(10, 10);
		Robot rob = new Robot(2, 2, "E", plateau);
		
		String command = "MMLM";
		rob.processCommands(command);
		
		Assert.assertTrue(rob.getPosition().equals("4 3 N"));
	}
	
	
	@Test
	public void testMoveForward() {
		
		Plateau plateau = new Plateau(10, 10);
		Robot rob = new Robot(3, 3, "E", plateau);
		
		String command = "MMMM";
		rob.processCommands(command);
		
		Assert.assertTrue(rob.getPosition().equals("7 3 E"));
	}
	
	
	@Test
	public void testRotate() {
		
		Plateau plateau = new Plateau(10, 10);
		Robot rob = new Robot(3, 3, "E", plateau);
		
		rob.processCommands("L");
		Assert.assertTrue(rob.getPosition().equals("3 3 N"));
		
		rob.processCommands("L");
		Assert.assertTrue(rob.getPosition().equals("3 3 W"));
		
		rob.processCommands("L");
		Assert.assertTrue(rob.getPosition().equals("3 3 S"));
		
		
		rob.processCommands("RR");
		Assert.assertTrue(rob.getPosition().equals("3 3 N"));
		
		rob.processCommands("R");
		Assert.assertTrue(rob.getPosition().equals("3 3 E"));
		
		rob.processCommands("R");
		Assert.assertTrue(rob.getPosition().equals("3 3 S"));
		
	}

}
