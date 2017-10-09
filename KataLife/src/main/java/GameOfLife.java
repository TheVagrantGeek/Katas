import exception.GameOfLifeParametersMissing;

import java.awt.*;

public class GameOfLife{

	private GameOfLifeParameters parameters;
	public GameOfLife(GameOfLifeParameters parameters)
	{
		if(parameters != null)
		{
			this.parameters = parameters;
		}
		else
		{
			throw new GameOfLifeParametersMissing();
		}
	}

	private Cell[] cells;
	public void run() {
		cells = new Cell[parameters.getGridSize().getArea()];
		for(Point p : parameters.getLiveCellsPositions())
		{
			cells[getCellIndex(p.x, p.y)] = new Cell(true);
		}
		for(int i = 0; i < )
		for(Cell c : cells)
		{
			if(c == null)
			{
				c = new Cell(false);
			}
		}
	}

	@Override public String toString()
	{
		String output = "";
		for(int y = 0; y < parameters.getGridSize().height;y++)
		{
			for(int x = 0; x < parameters.getGridSize().width; x++)
			{
				Cell c = cells[getCellIndex(x, y)];
				output += (c.isAlive() ? "#" : "*") + "";
			}
			output = output.trim();
			output += System.getProperty("line.separator");
		}
		return output.trim();
	}

	private int getCellIndex(int x, int y)
	{
		return (y * parameters.getGridSize().width) + x;
	}
}
