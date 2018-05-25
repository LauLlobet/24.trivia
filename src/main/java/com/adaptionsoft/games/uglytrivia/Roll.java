package com.adaptionsoft.games.uglytrivia;

public class Roll {
    private final int rollPrimitive;
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

    public boolean isNotPenality() {
        return ! isPenality();
    }

    public boolean isPenality() {
        return secondroll == 7;
    }

    public int getRollPrimitive() {
        return rollPrimitive;
    }
}
