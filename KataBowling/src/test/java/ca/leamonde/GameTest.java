package ca.leamonde;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void before(){
        game = new Game();
    }

    private void doRollsWithFixedNumberOfPins(int nbRolls, int nbPins)
    {
        for(int i = 0; i < nbRolls; i++)
            game.roll(nbPins);
    }

    private void doNumberOfSpareFrames(int nbFrames)
    {
        for(int i = 0; i < nbFrames; i++)
            doSpareFrame();
    }
    private void doSpareFrame()
    {
        game.roll(5);
        game.roll(5);
    }

    private void doNumberOfStrikeFrame(int nbFrames)
    {
        for(int i = 0; i < nbFrames; i++)
            doStrikeFrame();
    }

    private void doStrikeFrame()
    {
        game.roll(10);
    }


//    @Test(expected = Game.InvalidPinNumberException.class)
//    public void rollIsLessThenZeroPins_raiseException()
//    {
//        game.roll(-1);
//    }

    @Test
    public void whenRolledAllGutterBalls_scoreIsZero()
    {
        doRollsWithFixedNumberOfPins(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void whenRolledAllSinglePinBalls_scoreIsTwenty()
    {
        doRollsWithFixedNumberOfPins(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void whenFirstFrameIsSpareAndOthersAreSinglePinBalls_scoreIsTwentyNine()
    {
        doSpareFrame();
        doRollsWithFixedNumberOfPins(18, 1);
        assertEquals(29, game.score());
    }

    @Test
    public void allSpareGameWithTwoFivePinsRollsPerFrame_scoreIsOneHundredFifty()
    {
        doNumberOfSpareFrames(9);
        doRollsWithFixedNumberOfPins(3, 5);
        assertEquals(150, game.score());
    }

    @Test
    public void allStrikeGame_scoreIsThreeHundred()
    {
        doNumberOfStrikeFrame(9);
        doRollsWithFixedNumberOfPins(3, 10);
        assertEquals(300, game.score());
    }

}