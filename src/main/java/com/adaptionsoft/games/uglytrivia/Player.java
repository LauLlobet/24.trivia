package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String name;
    private int score;
    private boolean inPenaltyBox = false;

    public Player(String playerName) {
        this.name = playerName;
        this.score = 0;
    }

    public String toString() {
        return name;
    }

    public void increaseScoreByOne() {
        System.out.println("Answer was correct!!!!");
        score++;
        System.out.println(getStatusString());
    }

    public PenaltyStateFromPlayer getAndPrintPenaltyState(Roll roll) {
        PenaltyStateFromPlayer penaltyState = new PenaltyStateFromPlayer(roll,inPenaltyBox, name);
        penaltyState.printState();
        return penaltyState;
    }

    public boolean hasNotWon() {
        return !( score == 6);
    }


    public void setInPenaltyBoxDependingOn(Roll roll) {
        if(roll.isNotPenality()){
            return;
        }
        System.out.println("Question was incorrectly answered");
        System.out.println(name + " was sent to the penalty box");
        inPenaltyBox = true;
    }


    private String getStatusString() {
        return name + " now has " + score + " Gold Coins.";
    }

    public void printOwnTurn() {
        System.out.println(name + " is the current player");
    }


    public String getName() {
        return name;
    }
}
