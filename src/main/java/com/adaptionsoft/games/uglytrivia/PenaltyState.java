package com.adaptionsoft.games.uglytrivia;

import static java.lang.System.out;

public class PenaltyState {
    private final boolean isPenalizedTurn;
    private final boolean isInPenaltyBox;

    PenaltyState(Roll roll, boolean isInPenaltyBox) {
        this.isInPenaltyBox = isInPenaltyBox;
        if (this.isInPenaltyBox && roll.isNotEven()) {
            isPenalizedTurn = true;
            return;
        }
        isPenalizedTurn = false;
    }

    public void printStateFor(String name) {
        if (!isInPenaltyBox) {
            return;
        }
        if (isPenalizedTurn) {
            out.println(name + " is not getting out of the penalty box");
            return;
        }
        out.println(name + " is getting out of the penalty box");
    }

    public boolean hasANotAPenalisedTurn() {
        return !isPenalizedTurn;
    }

}
