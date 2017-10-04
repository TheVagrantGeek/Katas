import exception.InvalidParameterException;
import exception.MissingParameterException;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class GameOfLifeParameters {

	public static final String PROPERTY_GRID = "grid";
	public static final String PROPERTY_LIVE_CELLS = "liveCells";
	public static final String PROPERTY_GENERATIONS = "generations";

	private Properties properties = null;
	private GridSize gridSize = null;
	private Point[] liveCellsPositions;
	private int generationCount = -1;

	public GameOfLifeParameters(Properties properties) {
		if (properties != null && allRequiredPropertiesArePresent(properties)) {
			this.properties = properties;
			parseProperties();
		} else {
			throw new MissingParameterException();
		}
	}

	private boolean allRequiredPropertiesArePresent(Properties properties) {
		return properties.containsKey(PROPERTY_GRID) && properties.containsKey(PROPERTY_LIVE_CELLS) && properties
				.containsKey(PROPERTY_GENERATIONS);
	}

	private void parseProperties() {
		parseGridSize();
		parseLiveCells();
		parseGenerationCount();
	}

	private void parseGridSize() {
		String gridSizeString = properties.getProperty(PROPERTY_GRID).toLowerCase();
		if (gridSizeString.indexOf('x') != -1) {
			String[] sizes = gridSizeString.split("x");
			if (sizes.length == 2) {
				try {
					int width = Integer.parseInt(sizes[0]);
					int height = Integer.parseInt(sizes[1]);
					gridSize = new GridSize();
					gridSize.width = width;
					gridSize.height = height;
				} catch (NumberFormatException ex) {
					gridSize = null;
				}
			}
		}
		if (gridSize == null)
			throw new InvalidParameterException();
	}

	public void parseLiveCells() {
		List<Point> positions = new LinkedList<Point>();

		String liveCellsString = properties.getProperty(PROPERTY_LIVE_CELLS).toLowerCase();
		for (String liveCell : liveCellsString.split(";")) {
			try {
				String[] sizes = liveCell.split(",");
				if (sizes.length == 2) {
					int x = Integer.parseInt(sizes[0]);
					int y = Integer.parseInt(sizes[1]);
					Point p = new Point();
					p.x = x;
					p.y = y;
					positions.add(p);
				}
			} catch (NumberFormatException ex) {
				throw new InvalidParameterException();
			}
		}
		liveCellsPositions = new Point[positions.size()];
		positions.toArray(liveCellsPositions);
	}

	public void parseGenerationCount() {
		String generationCountString = properties.getProperty(PROPERTY_GENERATIONS);
		try {
			generationCount = Integer.parseInt(generationCountString);
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException();
		}
	}

	public GridSize getGridSize() {
		return gridSize;
	}

	public Point[] getLiveCellsPositions() {
		return liveCellsPositions;
	}

	public int getGenerationCount() {
		return generationCount;
	}
}
