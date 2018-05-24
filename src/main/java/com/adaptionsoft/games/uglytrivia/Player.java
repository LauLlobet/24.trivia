package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int score;
    private boolean notGettingOutOfPenaltyBox;
    boolean inPenaltyBox = false;
    private PenaltyState penaltyState = new PenaltyState();

    Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public String toString() {
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




    public void setInPenaltyBox() {
        this.inPenaltyBox = true;
        penaltyState.setInPenaltyBox();
    }

    public boolean hasAPenalisedTurn() {
        return penaltyState.hasAPenalisedTurn();
    }

    public void penaliseTurnIfItsOnPenaltyBoxDependingOn(Roll roll) {
        if (isNotInPenaltyBox()) {
            return;
        }
        penaliseTurnDependingOn(roll);
        penaltyState.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);

    }

    public void setNonPenalisedTurn() {
        System.out.println(this + " is getting out of the penalty box");
        notGettingOutOfPenaltyBox = false;
    }



    private void setPenalisedTurn() {
        System.out.println(this + " is not getting out of the penalty box");
        notGettingOutOfPenaltyBox = true;
    }

    private void penaliseTurnDependingOn(Roll roll) {
        if (!roll.isEven()) {
            setPenalisedTurn();
            return;
        }
        setNonPenalisedTurn();
    }

    private boolean isNotInPenaltyBox() {
        return !inPenaltyBox;
    }




}
