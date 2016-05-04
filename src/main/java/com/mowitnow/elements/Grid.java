package com.mowitnow.elements;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private List<Position> gridList = new ArrayList<Position>();
	private Position maxPosition;

	public Grid(Position maxPosition) {
		setMaxPosition(maxPosition);
		for (int x = 0; x < maxPosition.getX(); x++) {
			for (int y = 0; y < maxPosition.getY(); y++) {
				gridList.add(new Position(x, y, null, false));
			}
		}
	}

	public Boolean isPositionMowed(Position position) {
		for (Position positionTemp : gridList) {
			if (position.getX() == positionTemp.getX() && position.getY() == positionTemp.getY()) {
				return positionTemp.getIsMowed();
			}

		}
		return null;
	}

	public Boolean isPositionValid(Position position) {
		Boolean ret;
		if ((0 <= position.getX() && position.getX() <= maxPosition.getX())
				&& (0 <= position.getY() && position.getY() <= maxPosition.getY())) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	public void mowPosition(Position position) {
		for (Position positionTemp : gridList) {
			if (position.getX() == positionTemp.getX() && position.getY() == positionTemp.getY()) {
				positionTemp.setIsMowed(Boolean.TRUE);
			}

		}
	}

	public List<Position> getGridList() {
		return gridList;
	}

	public void setGridList(List<Position> gridList) {
		this.gridList = gridList;
	}

	public Position getMaxPosition() {
		return maxPosition;
	}

	public void setMaxPosition(Position maxPosition) {
		this.maxPosition = maxPosition;
	}

}
