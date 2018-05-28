package com.adaptionsoft.games.uglytrivia;

import static java.lang.System.out;

public class PenaltyStateFromPlayer {
    private final boolean isPenalizedTurn;
    private final Roll roll;
    private final boolean isInPenaltyBox;
    private final String name;

    PenaltyStateFromPlayer(Roll roll, boolean isInPenaltyBox, String name) {
        this.roll = roll;
        this.isInPenaltyBox = isInPenaltyBox;
        this.name = name;
        if (this.isInPenaltyBox && roll.isNotEven()) {
            isPenalizedTurn = true;
            return;
        }
        isPenalizedTurn = false;
    }

    public void printState() {
        if (!isInPenaltyBox) {
            return;
        }
        if (isPenalizedTurn) {
            out.println(name + " is not getting out of the penalty box");
            return;
        }
        out.println(name + " is getting out of the penalty box");
    }

    public boolean isNotPenalisedTurn() {
        return !isPenalizedTurn;
    }

    public boolean canScore() {
        return isNotPenalisedTurn() && roll.isNotPenality();
    }
}
