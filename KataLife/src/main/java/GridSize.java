public class GridSize {
	public GridSize()
	{
		this(0,0);
	}
	public GridSize(int w, int h)
	{
		width = w;
		height = h;
	}
	public int width;
	public int height;

	public int getNumberOfCells() {
		return width * height;
	}
}
