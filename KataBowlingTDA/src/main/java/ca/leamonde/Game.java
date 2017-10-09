package ca.leamonde;

public class Game {

    private final int ROLLS_PER_FRAME_FOR_STRIKE = 1;
    private final int ROLLS_PER_FRAME_FOR_SPARE = 2;
    private final int NB_BONUS_FOR_STRIKE = 2;
    private final int NB_BONUS_FOR_SPARE = 1;

    private final int NB_FRAMES = 10;
    private final int PINS_PER_FRAME = 10;
    private final int[] NB_ROLLS_PER_FRAME = {2,2,2,2,2,2,2,2,2,3};

    private int totalScore = 0;

    private int[] nbBonusPerFrame = new int[NB_FRAMES];

    private int frameCounter = 0;
    private int frameScore = 0;
    private int rollsInFrame = 0;


    public void roll(int pins)
    {
        totalScore += pins;
        addBonusForPreviousFrames(pins);

        rollsInFrame += 1;
        frameScore += pins;

        //Usual case : All frames except the last one.
        if(frameCounter < NB_FRAMES-1)
        {
            if(frameScore == PINS_PER_FRAME || rollsInFrame == NB_ROLLS_PER_FRAME[frameCounter]) {
                if (frameScore == PINS_PER_FRAME)
                {
                    if (rollsInFrame == ROLLS_PER_FRAME_FOR_STRIKE)
                    {
                        nbBonusPerFrame[frameCounter] = NB_BONUS_FOR_STRIKE;
                    }
                    else if (rollsInFrame == ROLLS_PER_FRAME_FOR_SPARE)
                    {
                        nbBonusPerFrame[frameCounter] = NB_BONUS_FOR_SPARE;
                    }
                }
                startNewFrame();
            }
        }

    }

    private void addBonusForPreviousFrames(int bonus)
    {
        for(int i = 0; i < NB_FRAMES; i++)
        {
            if(nbBonusPerFrame[i] > 0)
            {
                totalScore += bonus;
                nbBonusPerFrame[i] -= 1;
            }
        }
    }

    private void startNewFrame()
    {
        rollsInFrame = 0;
        frameScore = 0;
        frameCounter += 1;
    }

    public int score()
    {
        return totalScore;
    }

}


