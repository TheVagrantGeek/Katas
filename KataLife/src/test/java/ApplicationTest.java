import exception.MissingParameterException;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Properties;

public class ApplicationTest {

	@Mock Properties emptyProperties;

	@Test(expected = MissingParameterException.class)
	public void givenMissingParameters_whenStartingApplication_applicationStops()
	{
		Application app = new Application();
		app.run(null);
	}

	@Test(expected = MissingParameterException.class)
	public void givenEmptyParameters_whenStartingApplication_applicationStops()
	{
		Application app = new Application();
		app.run(emptyProperties);
	}

	//	private Properties completeButInvalidProperties;
	//	private Application app;
	//
	//	@Before
	//	public void initialize() {
	//		app = new Application();
	//
	//		completeButInvalidProperties = new Properties();
	//		completeButInvalidProperties.put(Application.PROPERTY_GRID, "");
	//		completeButInvalidProperties.put(Application.PROPERTY_LIVE_CELLS, "");
	//		completeButInvalidProperties.put(Application.PROPERTY_GENERATIONS, "");
	//	}
	//
	//	@Test(expected = MissingParameterException.class)
	//	public void givenNoProperties_whenApplicationRuns_applicationThrowsException() throws MissingParameterException {
	//		app.run(null);
	//	}
	//
	//	@Test(expected = MissingParameterException.class)
	//	public void givenEmptyProperties_whenApplicationRuns_applicationThrowsException() throws MissingParameterException {
	//		app.run(new Properties());
	//	}
	//
	//	@Test(expected = MissingParameterException.class)
	//	public void givenIncompleteProperties_whenApplicationRuns_applicationThrowsException()
	//			throws MissingParameterException {
	//		Properties incompleteProperties = new Properties();
	//		incompleteProperties.setProperty("grid", "dsada");
	//		app.run(incompleteProperties);
	//	}
	//
	//	@Test(expected = InvalidParameterException.class)
	//	public void givenAnyInvalidProperty_whenApplicationRuns_applicationThrowsException()
	//			throws MissingParameterException, InvalidParameterException {
	//		app.run(completeButInvalidProperties);
	//	}
}