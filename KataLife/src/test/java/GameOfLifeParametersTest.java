import exception.InvalidParameterException;
import exception.MissingParameterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class GameOfLifeParametersTest {

	private GameOfLifeParameters parameters;

	@Before
	public void initialize() {
	}

	@Test(expected = MissingParameterException.class)
	public void givenNoProperties_whenCreating_constructorThrowsException()
			throws MissingParameterException, InvalidParameterException {
		parameters = new GameOfLifeParameters(null);
	}

	@Test(expected = MissingParameterException.class)
	public void givenEmptyProperties_whenCreating_constructorThrowsException()
			throws MissingParameterException, InvalidParameterException {
		parameters = new GameOfLifeParameters(new Properties());
	}

	@Test(expected = MissingParameterException.class)
	public void givenIncompleteProperties_whenCreating_constructorThrowsException()
			throws MissingParameterException, InvalidParameterException {
		Properties incompleteProperties = new Properties();
		incompleteProperties.setProperty("grid", "dsada");
		parameters = new GameOfLifeParameters(incompleteProperties);
	}

	@Test(expected = InvalidParameterException.class)
	public void givenAnyInvalidProperty_whenApplicationRuns_applicationThrowsException()
			throws MissingParameterException, InvalidParameterException {
		Properties completeButInvalidProperties = new Properties();
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_GRID, "");
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_LIVE_CELLS, "");
		completeButInvalidProperties.put(GameOfLifeParameters.PROPERTY_GENERATIONS, "");

		parameters = new GameOfLifeParameters(completeButInvalidProperties);
	}
}