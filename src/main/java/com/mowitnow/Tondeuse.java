package com.mowitnow;

import com.mowitnow.elements.Position;
import com.mowitnow.utils.Parser;

public class Tondeuse {

	public static void main(String[] args) {
		Parser parser = new Parser("FichierIn.txt");
		parser.mowAll();
		for (Position position : parser.getEndPositionList()) {
			System.out.println(position.getX() + " " + position.getY() + " " + position.getDirection());
		}

	}

}
