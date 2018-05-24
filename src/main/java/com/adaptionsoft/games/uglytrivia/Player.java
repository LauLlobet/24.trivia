package com.adaptionsoft.games.uglytrivia;

public class Player {

    private final String playerName;
    private int score;
    private boolean notGettingOutOfPenaltyBox;
    boolean inPenaltyBox = false;
    private PenaltyState penaltyState = new PenaltyState();



    public void setInPenaltyBox() {
        this.inPenaltyBox = true;
    }



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

    public boolean hasAPenalisedTurn() {
        return notGettingOutOfPenaltyBox;
    }


    public void setNonPenalisedTurn() {
        System.out.println(this + " is getting out of the penalty box");
        notGettingOutOfPenaltyBox = false;
    }

    void setPenalisedTurn() {
        System.out.println(this + " is not getting out of the penalty box");
        notGettingOutOfPenaltyBox = true;
    }


    public void penaliseTurnIfItsOnPenaltyBoxDependingOn(Roll roll) {
        if (isNotInPenaltyBox()) {
            return;
        }
        penaliseTurnDependingOn(roll);

    }

    private void penaliseTurnDependingOn(Roll roll) {
        if (!roll.isEven()) {
            setPenalisedTurn();
            return;
        }
        setNonPenalisedTurn();
    }

    public boolean isNotInPenaltyBox() {
        return !inPenaltyBox;
    }
}
