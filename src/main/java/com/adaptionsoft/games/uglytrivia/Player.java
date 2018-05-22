package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int score;

    public Player(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
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
