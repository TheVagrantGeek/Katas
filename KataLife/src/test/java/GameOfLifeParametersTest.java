import exception.InvalidParameterException;
import exception.MissingParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class GameOfLifeParametersTest {

	private static final String VALID_GRID_PARAMETER = "4x5";
	private static final int EXPECTED_GRID_WIDTH = 4;
	private static final int EXPECTED_GRID_HEIGHT = 5;
	private static final String VALID_LIVE_CELLS = "2,3;1,5;";
	private static final int EXPECTED_FIRST_LIVE_CELL_X = 2;
	private static final int EXPECTED_FIRST_LIVE_CELL_Y = 3;
	private static final int EXPECTED_SECOND_LIVE_CELL_X = 1;
	private static final int EXPECTED_SECOND_LIVE_CELL_Y = 5;
	private static final String VALID_GENERATION_COUNT = "2";
	private static final int EXPECTED_GENERATION_COUNT = 2;

	private GameOfLifeParameters parameters;

	private Properties validProperties;

	@Before
	public void initialize() {
		validProperties = new Properties();
		validProperties.put(GameOfLifeParameters.PROPERTY_GRID, VALID_GRID_PARAMETER);
		validProperties.put(GameOfLifeParameters.PROPERTY_LIVE_CELLS, VALID_LIVE_CELLS);
		validProperties.put(GameOfLifeParameters.PROPERTY_GENERATIONS, VALID_GENERATION_COUNT);
	}

	@Test(expected = MissingParameterException.class)
	public void givenNoProperties_whenCreating_constructorThrowsException() {
		parameters = new GameOfLifeParameters(null);
	}

	@Test(expected = MissingParameterException.class)
	public void givenEmptyProperties_whenCreating_constructorThrowsException() {
		parameters = new GameOfLifeParameters(new Properties());
	}

	@Test(expected = MissingParameterException.class)
	public void givenIncompleteProperties_whenCreating_constructorThrowsException() {
		Properties incompleteProperties = new Properties();
		incompleteProperties.setProperty("grid", "dsada");
		parameters = new GameOfLifeParameters(incompleteProperties);
	}

	@Test(expected = InvalidParameterException.class)
	public void givenAnyInvalidProperty_whenCreating_applicationThrowsException() {
		Properties completeButInvalidProperties = new Properties();
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_GRID, "");
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_LIVE_CELLS, "");
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_GENERATIONS, "");
		parameters = new GameOfLifeParameters(completeButInvalidProperties);
	}

	@Test
	public void givenAValidGridSize_whenCreating_gridSizeIsNotNull() {
		parameters = new GameOfLifeParameters(validProperties);

		assertNotNull(parameters.getGridSize());
	}

	@Test
	public void givenAValidGridSize_whenCreating_gridSizeIsOfRightSize() {
		parameters = new GameOfLifeParameters(validProperties);

		assertEquals(EXPECTED_GRID_WIDTH, parameters.getGridSize().width);
		assertEquals(EXPECTED_GRID_HEIGHT, parameters.getGridSize().height);
	}

	@Test
	public void givenValidLiveCells_whenCreating_liveCellsPositionsIsNotNull() {
		parameters = new GameOfLifeParameters(validProperties);

		assertNotNull(parameters.getLiveCellsPositions());
	}

	@Test
	public void givenValidLiveCells_whenCreating_liveCellsPositionsAreCorrect() {
		parameters = new GameOfLifeParameters(validProperties);

		assertEquals(EXPECTED_FIRST_LIVE_CELL_X, parameters.getLiveCellsPositions()[0].x);
		assertEquals(EXPECTED_FIRST_LIVE_CELL_Y, parameters.getLiveCellsPositions()[0].y);
		assertEquals(EXPECTED_SECOND_LIVE_CELL_X, parameters.getLiveCellsPositions()[1].x);
		assertEquals(EXPECTED_SECOND_LIVE_CELL_Y, parameters.getLiveCellsPositions()[1].y);
	}

	@Test
	public void givenAValidGenerationCount_whenCreating_generationCountIsValid() {
		parameters = new GameOfLifeParameters(validProperties);

		assertTrue(parameters.getGenerationCount() >= 0);
	}

	@Test
	public void givenAValidGenerationCount_whenCreating_generationCountIsCorrect() {
		parameters = new GameOfLifeParameters(validProperties);

		assertEquals(EXPECTED_GENERATION_COUNT, parameters.getGenerationCount());
	}
}