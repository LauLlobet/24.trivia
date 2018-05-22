package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int score;

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    private final int numberOfPlayer;

    public Player(String playerName, int score, int numberOfPlayer) {
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
}
