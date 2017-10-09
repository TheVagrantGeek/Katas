import exception.GameOfLifeParametersMissing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameOfLifeTest {
	@Mock
	GameOfLifeParameters validParameters;
	private static final GridSize GRID_SIZE = new GridSize(4,5);
	private static final Point[] POINTS = {new Point(1,2), new Point(3,4)};
	private static final int GENERATION_COUNT = 2;

	@Before
	public void initialize()
	{
		validParameters = mock(GameOfLifeParameters.class);
		willReturn(GRID_SIZE).given(validParameters).getGridSize();
		willReturn(POINTS).given(validParameters).getLiveCellsPositions();
		willReturn(GENERATION_COUNT).given(validParameters).getGenerationCount();
	}

	@Test(expected = GameOfLifeParametersMissing.class)
	public void givenNoParameters_whenCreating_exceptionIsThrown()
	{
		GameOfLife game = new GameOfLife(null);
	}

	@Test
	public void givenValidParameters_whenCreating_gameIsCreated()
	{
		GameOfLife game = new GameOfLife(validParameters);
		assertNotNull(game);
	}

	private static final String SEP = System.getProperty("line.separator");

	@Test
	public void givenNoLiveCellGridAndNoGeneration_whenRunning_gameStateAllDead()
	{
		GameOfLifeParameters emptyGridParameters = mock(GameOfLifeParameters.class);
		when(emptyGridParameters.getGridSize()).thenReturn(new GridSize(5,5));
		when(emptyGridParameters.getLiveCellsPositions()).thenReturn(new Point[0]);
		when(emptyGridParameters.getGenerationCount()).thenReturn(0);

		GameOfLife game = new GameOfLife(emptyGridParameters);
		game.run();

		assertEquals("* * * * *" + SEP + "* * * * *" + SEP + "* * * * *" + SEP + "* * * * *" + SEP + "* * * * *", game.toString());
	}

	@Test
	public void givenOneLiveCellAndNoGeneration_whenRunning_gameStateIsCorrect()
	{
		GameOfLifeParameters mockedGridParameters = mock(GameOfLifeParameters.class);
		when(mockedGridParameters.getGridSize()).thenReturn(new GridSize(5,5));
		when(mockedGridParameters.getLiveCellsPositions()).thenReturn(new Point[]{new Point(2,2)});
		when(mockedGridParameters.getGenerationCount()).thenReturn(0);

		GameOfLife game = new GameOfLife(mockedGridParameters);
		game.run();

		assertEquals("* * * * *" + SEP + "* * * * *" + SEP + "* * # * *" + SEP + "* * * * *" + SEP + "* * * * *", game.toString());
	}



	public void givenValidParameters_whenRunningGame_correctGameIsPlayed()
	{
		GameOfLife game = new GameOfLife(validParameters);
		game.run();
		assertEquals("", game.toString());
	}
}