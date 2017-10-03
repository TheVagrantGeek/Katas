import exception.InvalidParameterException;
import exception.MissingParameterException;

import java.util.Properties;

public class GameOfLifeParameters {

	public static final String PROPERTY_GRID = "grid";
	public static final String PROPERTY_LIVE_CELLS = "liveCells";
	public static final String PROPERTY_GENERATIONS = "generations";

	public GameOfLifeParameters(Properties properties) throws MissingParameterException, InvalidParameterException {
		if (properties != null && allRequiredPropertiesArePresent(properties)) {
			parseProperties();
		} else {
			throw new MissingParameterException();
		}
	}

	private boolean allRequiredPropertiesArePresent(Properties properties) {
		return properties.containsKey(PROPERTY_GRID) && properties.containsKey(PROPERTY_LIVE_CELLS) && properties
				.containsKey(PROPERTY_GENERATIONS);
	}

	private boolean parseProperties() throws InvalidParameterException {
		throw new InvalidParameterException();
	}
}
