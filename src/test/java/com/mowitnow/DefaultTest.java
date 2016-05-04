package com.mowitnow;

import org.junit.Assert;
import org.junit.Test;

import com.mowitnow.elements.Position;
import com.mowitnow.utils.Parser;

public class DefaultTest {

	@Test
	public void testGlobal() {
		Parser parser = new Parser("FichierIn.txt");
		parser.mowAll();

		Assert.assertNotNull(parser.getEndPositionList());
		Position position1 = parser.getEndPositionList().get(0);
		Position position2 = parser.getEndPositionList().get(1);

		Assert.assertEquals(position1.getX(), 1);
		Assert.assertEquals(position1.getY(), 3);
		Assert.assertEquals(position1.getDirection().toString(), "N");

		Assert.assertEquals(position2.getX(), 5);
		Assert.assertEquals(position2.getY(), 1);
		Assert.assertEquals(position2.getDirection().toString(), "E");

	}

}
