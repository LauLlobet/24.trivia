package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int score;
    private boolean notGettingOutOfPenaltyBox;

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    boolean inPenaltyBox = false;

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    private final int numberOfPlayer;

    Player(String playerName, int score, int numberOfPlayer) {
        this.playerName = playerName;
        this.score = score;
        this.numberOfPlayer = numberOfPlayer;
    }

    public String toString(){
        return playerName;
    }

    public void increaseScoreByOne() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getStatusString() {
        return playerName + " now has "
                        + score
                        + " Gold Coins.";
    }

    public void announceOwnTurn() {
        System.out.println(this + " is the current player");
    }

    public boolean isNotGettingOutOfPenaltyBox() {
        return notGettingOutOfPenaltyBox;
    }

    public void setNotGettingOutOfPenaltyBox() {
        notGettingOutOfPenaltyBox = true;
    }

    public void setGettingOutOfPenaltyBox() {
        notGettingOutOfPenaltyBox = false;
    }
}
