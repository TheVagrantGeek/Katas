package ca.leamonde;

public class Scorekeeper {

    private final int SCORE_STRING_LENGTH = 3;
    private int scoreA = 0;
    private int scoreB = 0;

    public void scoreTeamA1(){
        scoreA += 1;
    }

    public void scoreTeamA2(){
        scoreA += 2;
    }

    public void scoreTeamA3(){
        scoreA += 3;
    }

    public void scoreTeamB1(){
        scoreB += 1;
    }

    public void scoreTeamB2(){
        scoreB += 2;
    }

    public void scoreTeamB3(){
        scoreB += 3;
    }



    public String getScore()
    {
        return formatScore(scoreA) + ":" + formatScore(scoreB);
    }

    private String formatScore(int score)
    {
        return padScore(Integer.toString(score));
    }

    private String padScore(String score)
    {
        while(score.length() < SCORE_STRING_LENGTH)
        {
            score = "0" + score;
        }
        return score;
    }
}
