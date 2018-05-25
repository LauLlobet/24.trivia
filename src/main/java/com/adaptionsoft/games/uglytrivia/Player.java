package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String name;
    private int score;
    boolean inPenaltyBox = false;
    private PenaltyState penaltyState = new PenaltyState();

    public Player(String playerName) {
        this.name = playerName;
        this.score = 0;
    }

    public String toString() {
        return name;
    }

    public void increaseScoreByOne() {
        if (hasAPenalisedTurn()) {
            return;
        }
        System.out.println("Answer was correct!!!!");
        score++;
        System.out.println(getStatusString());
    }


    public boolean hasAPenalisedTurn() {
        return penaltyState.hasAPenalisedTurn();
    }

    public boolean isNotPenalizedTurnAcordingToPenalizingBoxAnd(Roll roll) {
        penaltyState.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);
        penaltyState.printStateFor(name);
        return ! hasAPenalisedTurn();
    }

    public boolean hasNotWon() {
        return !( score == 6) || inPenaltyBox;
    }


    public void setInPenaltyBox() {
        System.out.println("Question was incorrectly answered");
        System.out.println(name + " was sent to the penalty box");
        penaltyState.setInPenaltyBox();
    }


    private String getStatusString() {
        return name + " now has " + score + " Gold Coins.";
    }

    public void announceOwnTurn() {
        System.out.println(name + " is the current player");
    }


}
