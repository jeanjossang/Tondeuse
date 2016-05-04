package com.mowitnow.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mowitnow.elements.Grid;
import com.mowitnow.elements.Path;
import com.mowitnow.elements.Position;

public class Parser {
	private Grid grid;
	private List<Path> pathList = new ArrayList<>();
	private List<Position> endPositionList = new ArrayList<>();

	public Parser(String filePath) {

		try {
			File f = new File(filePath);
			Scanner scanner = new Scanner(f);

			Position maxPosition = new Position(scanner.nextInt(), scanner.nextInt(), null, Boolean.FALSE);
			setGrid(new Grid(maxPosition));

			Position initialPosition = fillInitialPosition(scanner, scanner.nextInt());

			List<ActionEnum> actionsList = new ArrayList<>();

			while (scanner.hasNext()) {
				Object obj = scanner.next();

				if (obj.toString().startsWith("G") || obj.toString().startsWith("D")
						|| obj.toString().startsWith("A")) {
					fillActionsList(actionsList, obj);
					Path pathTemp = new Path(initialPosition, actionsList, maxPosition, grid);
					pathList.add(pathTemp);
					actionsList = new ArrayList<>();
				} else {

					initialPosition = fillInitialPosition(scanner, Integer.parseInt(obj.toString()));
				}

			}

			scanner.close();
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}

	}

	private void fillActionsList(List<ActionEnum> actionsList, Object obj) {
		String strTemp = obj.toString();
		for (int i = 0; i < obj.toString().length(); i++) {
			char charTemp = strTemp.charAt(i);
			switch (charTemp) {
			case 'G':
				actionsList.add(ActionEnum.G);
				break;
			case 'D':
				actionsList.add(ActionEnum.D);
				break;
			case 'A':
				actionsList.add(ActionEnum.A);
				break;
			default:
				break;
			}
		}
	}

	public void mowAll() {
		for (Path pathTemp : pathList) {
			pathTemp.mow();
			endPositionList.add(pathTemp.getEndPosition());
		}
	}

	private Position fillInitialPosition(Scanner scanner, int x) {

		int y = scanner.nextInt();
		String direction = scanner.next();
		DirectionEnum directionTrue = null;
		switch (direction) {
		case "N":
			directionTrue = DirectionEnum.N;
			break;
		case "E":
			directionTrue = DirectionEnum.E;
			break;
		case "S":
			directionTrue = DirectionEnum.S;
			break;
		case "W":
			directionTrue = DirectionEnum.W;
			break;
		default:
			break;
		}
		return new Position(x, y, directionTrue, Boolean.FALSE);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public List<Path> getPathList() {
		return pathList;
	}

	public void setPathList(List<Path> pathList) {
		this.pathList = pathList;
	}

	public List<Position> getEndPositionList() {
		return endPositionList;
	}

	public void setEndPositionList(List<Position> endPositionList) {
		this.endPositionList = endPositionList;
	}
}
