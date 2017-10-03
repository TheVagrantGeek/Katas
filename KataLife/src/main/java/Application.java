import exception.MissingParameterException;

import java.util.Properties;

public class Application
{
	public static final String PROPERTY_GRID = "grid";
	public static final String PROPERTY_LIVE_CELLS = "liveCells";
	public static final String PROPERTY_GENERATIONS = "generations";
	private Properties properties;

	public void run(Properties properties) throws MissingParameterException {
		if(properties != null && allRequiredPropertiesArePresent(properties))
		{
			if()
		}
		else
		{
			throw new MissingParameterException();
		}
	}

	private boolean allRequiredPropertiesArePresent(Properties properties)
	{
		return properties.containsKey(PROPERTY_GRID)
				&& properties.containsKey(PROPERTY_LIVE_CELLS)
				&& properties.containsKey(PROPERTY_GENERATIONS);
	}

}
