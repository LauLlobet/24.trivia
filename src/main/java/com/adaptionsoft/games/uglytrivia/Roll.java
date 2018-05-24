package com.adaptionsoft.games.uglytrivia;

public class Roll {
    public int getRollPrimitive() {
        return rollPrimitive;
    }

    private final int rollPrimitive;

    public boolean isPenalityRoll() {
        return secondroll == 7;
    }

    private final int secondroll;

    public Roll(int rollPrimitive, int secondroll) {

        this.rollPrimitive = rollPrimitive;
        this.secondroll = secondroll;
    }

    public boolean isEven(){
        return rollPrimitive % 2 != 0;
    }

    @Override
    public String toString() {
        return ""+rollPrimitive;
    }

    public void announceIt() {
        System.out.println("They have rolled a " + rollPrimitive);
    }
}
