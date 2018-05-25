package com.adaptionsoft.games.uglytrivia;

public class PenaltyState {
    private boolean penalizedTurn;
    private boolean inPenaltyBox = false;

    public PenaltyState(Roll roll, boolean inPenaltyBox){
        this.inPenaltyBox = inPenaltyBox;
        if(!inPenaltyBox){
            penalizedTurn = false;
        }
        if (!roll.isEven()) {
            penalizedTurn = true;
            return;
        }
        penalizedTurn = false;
    }

    public PenaltyState() {

    }


    public void printStateFor(String name){
        if(isNotInPenaltyBox()){
            return;
        }
        if(!penalizedTurn) {
            System.out.println(name + " is getting out of the penalty box");
            return;
        }
        System.out.println(name + " is not getting out of the penalty box");
    }

    public void penaliseTurnIfItsOnPenaltyBoxDependingOn(Roll roll) {
        if (isInPenaltyBox()) {
            penaliseTurnDependingOn(roll);
        }
    }

    //--

    private void penaliseTurnDependingOn(Roll roll) {
        if (!roll.isEven()) {
            setPenalisedTurn();
            return;
        }
        setNonPenalisedTurn();
    }

    public boolean hasAPenalisedTurn() {
        return penalizedTurn;
    }

    public void setInPenaltyBox() {
        this.inPenaltyBox = true;
    }

    private boolean isNotInPenaltyBox() {
        return !inPenaltyBox;
    }

    private void setNonPenalisedTurn() {
        penalizedTurn = false;
    }

    private void setPenalisedTurn() {
        penalizedTurn = true;
    }

    boolean isInPenaltyBox() {
        return inPenaltyBox;
    }
}
