package org.bones.roboticsquad;

import static org.junit.Assert.*;

import org.bones.roboticsquad.model.Plateau;
import org.junit.Test;


public class PlateauTest {

	@Test
	public void testBoundaries() {
		Plateau plateau = new Plateau(5, 5);
		
		assertFalse(plateau.isValidLocation(6, 5));
		assertTrue(plateau.isValidLocation(3, 3));
	}

}
