package ca.leamonde;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScorekeeperTest {

    private Scorekeeper keeper;
    @Before
    public void before(){
        keeper = new Scorekeeper();
    }

    @Test
    public void givenNewScorekeeper_scoreIsZeroZero()
    {
        assertEquals("000:000", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamAScoreOne_scoreIsOneZero()
    {
        keeper.scoreTeamA1();
        assertEquals("001:000", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamBScoreOne_scoreIsZeroOne()
    {
        keeper.scoreTeamB1();
        assertEquals("000:001", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamAScoreTwo_scoreIsTwoZero()
    {
        keeper.scoreTeamA2();
        assertEquals("002:000", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamBScoreTwo_scoreIsZeroTwo()
    {
        keeper.scoreTeamB2();
        assertEquals("000:002", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamAScoreThree_scoreIsThreeZero()
    {
        keeper.scoreTeamA3();
        assertEquals("003:000", keeper.getScore());
    }

    @Test
    public void givenNewScorekeeper_teamBScoreThree_scoreIsZeroThree()
    {
        keeper.scoreTeamB3();
        assertEquals("000:003", keeper.getScore());
    }

    @Test
    public void teamAScoresOverNinePoints_scoreFormatedWithOneZeroOnTheLeft()
    {
        keeper.scoreTeamA3();
        keeper.scoreTeamA3();
        keeper.scoreTeamA3();
        keeper.scoreTeamA1();
        assertEquals("010:000", keeper.getScore());
    }

    @Test
    public void teamBScoresOverNinePoints_scoreFormatedWithOneZeroOnTheLeft()
    {
        keeper.scoreTeamB3();
        keeper.scoreTeamB3();
        keeper.scoreTeamB3();
        keeper.scoreTeamB1();
        assertEquals("000:010", keeper.getScore());
    }
}