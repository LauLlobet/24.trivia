package com.adaptionsoft.games.uglytrivia;

public class PenaltyState {
    private boolean notGettingOutOfPenaltyBox;
    boolean inPenaltyBox = false;

    public void setInPenaltyBox() {
        this.inPenaltyBox = true;
    }

    public boolean hasAPenalisedTurn() {
        return notGettingOutOfPenaltyBox;
    }


    public void setNonPenalisedTurn() {
        notGettingOutOfPenaltyBox = false;
    }

    void setPenalisedTurn() {
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

    public void printStateFor(String name){
        if(isNotInPenaltyBox()){
            return;
        }
        if(notGettingOutOfPenaltyBox == false){
            System.out.println(name + " is getting out of the penalty box");

        }else {
            System.out.println(name + " is not getting out of the penalty box");
        }

    }

}
