package com.adaptionsoft.games.uglytrivia;

public class PenaltyState {
    private boolean penalizedTurn;
    private boolean inPenaltyBox = false;

    public PenaltyState(Roll roll, boolean inPenaltyBox){
        this.inPenaltyBox = inPenaltyBox;
        penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);
    }

    public void printStateFor(String name){
        if(!inPenaltyBox){
            return;
        }
        if(!penalizedTurn) {
            System.out.println(name + " is getting out of the penalty box");
            return;
        }
        System.out.println(name + " is not getting out of the penalty box");
    }

    public void penaliseTurnIfItsOnPenaltyBoxDependingOn(Roll roll) {
        if (inPenaltyBox) {
            penaliseTurnDependingOn(roll);
        }
    }


    public boolean hasANotAPenalisedTurn() {
        return !penalizedTurn;
    }

    //--

    private void penaliseTurnDependingOn(Roll roll) {
        if (!roll.isEven()) {
            penalizedTurn = true;
            return;
        }
        penalizedTurn = false;
    }


}
