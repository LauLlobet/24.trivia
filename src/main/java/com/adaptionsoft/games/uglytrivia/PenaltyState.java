package com.adaptionsoft.games.uglytrivia;

public class PenaltyState {
    private final boolean penalizedTurn;
    private final boolean inPenaltyBox;

    public PenaltyState(Roll roll, boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
        if (this.inPenaltyBox && roll.isNotEven()) {
            penalizedTurn = true;
            return;
        }
        penalizedTurn = false;
    }

    public void printStateFor(String name) {
        if (!inPenaltyBox) {
            return;
        }
        if (!penalizedTurn) {
            System.out.println(name + " is getting out of the penalty box");
            return;
        }
        System.out.println(name + " is not getting out of the penalty box");
    }


    public boolean hasANotAPenalisedTurn() {
        return !penalizedTurn;
    }

}
