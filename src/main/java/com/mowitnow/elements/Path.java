package com.mowitnow.elements;

import java.util.List;

import com.mowitnow.utils.ActionEnum;
import com.mowitnow.utils.DirectionEnum;

public class Path {
	private Position initialPosition;
	private List<ActionEnum> actionsList;

	private Position positionMax;
	private Position endPosition;
	private Grid grid;

	public Path(Position initialPosition, List<ActionEnum> actionsList, Position positionMax, Grid grid) {
		setActionsList(actionsList);
		setInitialPosition(initialPosition);
		setPositionMax(positionMax);
		setGrid(grid);
	}

	public void mow() {
		Position currentPosition = initialPosition;
		for (ActionEnum actionEnum : actionsList) {
			grid.mowPosition(currentPosition);
			switch (actionEnum) {
			case G:
				currentPosition = turnLeft(currentPosition);
				break;
			case D:
				currentPosition = turnRight(currentPosition);
				break;
			case A:
				currentPosition = goForward(currentPosition);
				break;
			default:
				break;
			}
			setEndPosition(currentPosition);
		}
		
	}

	public Position turnLeft(Position position) {

		switch (position.getDirection()) {
		case N:
			position.setDirection(DirectionEnum.W);
			break;
		case E:
			position.setDirection(DirectionEnum.N);
			break;
		case S:
			position.setDirection(DirectionEnum.E);
			break;
		case W:
			position.setDirection(DirectionEnum.S);
			break;
		default:
			break;
		}
		return position;

	}

	public Position turnRight(Position position) {

		switch (position.getDirection()) {
		case N:
			position.setDirection(DirectionEnum.E);
			break;
		case E:
			position.setDirection(DirectionEnum.S);
			break;
		case S:
			position.setDirection(DirectionEnum.W);
			break;
		case W:
			position.setDirection(DirectionEnum.N);
			break;
		default:
			break;
		}
		return position;

	}

	public Position goForward(Position position) {
		Position positionNext = position;
		Position ret;
		switch (position.getDirection()) {
		case N:
			positionNext.setY(position.getY() + 1);

			break;
		case E:
			positionNext.setX(position.getX() + 1);

			break;
		case S:

			positionNext.setY(position.getY() - 1);

			break;
		case W:

			positionNext.setX(position.getX() - 1);

			break;
		default:
			break;
		}
		if (grid.isPositionValid(positionNext)) {
			ret = positionNext;
		} else {
			ret = position;
		}
		return ret;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public List<ActionEnum> getActionsList() {
		return actionsList;
	}

	public void setActionsList(List<ActionEnum> actionsList) {
		this.actionsList = actionsList;
	}

	public Position getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Position positionMax) {
		this.positionMax = positionMax;
	}

	public Position getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

}
