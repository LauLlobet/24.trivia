package com.adaptionsoft.games.uglytrivia;

public class PenaltyState {
    private boolean notGettingOutOfPenaltyBox;
    boolean inPenaltyBox = false;

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
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
