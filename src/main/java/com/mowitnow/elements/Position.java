package com.mowitnow.elements;

import com.mowitnow.utils.DirectionEnum;

/**
 * 
 * @author jean coordonnées x y cartésiens
 */
public class Position {
	private int x;
	private int y;
	private DirectionEnum direction;
	private Boolean isMowed;

	public Boolean getIsMowed() {
		return isMowed;
	}

	public void setIsMowed(Boolean isMowed) {
		this.isMowed = isMowed;
	}

	public Position(int x, int y, DirectionEnum direction, Boolean isMowed) {
		setX(x);
		setY(y);
		setDirection(direction);
		setIsMowed(isMowed);
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
