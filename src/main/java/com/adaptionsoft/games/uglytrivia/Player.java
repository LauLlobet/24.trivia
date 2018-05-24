package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String name;
    private int score;
    private boolean notGettingOutOfPenaltyBox;
    boolean inPenaltyBox = false;
    private PenaltyState penaltyState = new PenaltyState();

    Player(String playerName) {
        this.name = playerName;
        this.score = 0;
    }

    public String toString() {
        return name;
    }

    public void increaseScoreByOne() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getStatusString() {
        return name + " now has "
                + score
                + " Gold Coins.";
    }

    public void announceOwnTurn() {
        System.out.println(name + " is the current player");
    }


    public void setInPenaltyBox() {
        System.out.println("Question was incorrectly answered");
        System.out.println(name + " was sent to the penalty box");
        penaltyState.setInPenaltyBox();
    }

    public boolean hasAPenalisedTurn() {
        return penaltyState.hasAPenalisedTurn();
    }

    public void penaliseTurnIfItsOnPenaltyBoxDependingOn(Roll roll) {
        penaltyState.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);
        penaltyState.printStateFor(name);
    }

}
