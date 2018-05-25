package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String name;
    private int score;
    private PenaltyState penaltyState = new PenaltyState();
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


    private boolean hasAPenalisedTurn() {
        return penaltyState.hasAPenalisedTurn();
    }

    public boolean isNotPenalizedTurnAcordingToPenalizingBoxAnd(Roll roll) {
        penaltyState.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);

        PenaltyState temp = new PenaltyState(roll,inPenaltyBox);
        temp.printStateFor(name);
        return ! penaltyState.hasAPenalisedTurn();
    }

    public boolean hasNotWon() {
        return !( score == 6);
    }


    public void setInPenaltyBox() {
        System.out.println("Question was incorrectly answered");
        System.out.println(name + " was sent to the penalty box");
        penaltyState.setInPenaltyBox();
        inPenaltyBox = true;
    }


    private String getStatusString() {
        return name + " now has " + score + " Gold Coins.";
    }

    public void announceOwnTurn() {
        System.out.println(name + " is the current player");
    }


}
