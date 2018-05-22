package com.adaptionsoft.games.uglytrivia;

public class Roll {
    public int getRollPrimitive() {
        return rollPrimitive;
    }

    private final int rollPrimitive;

    public Roll(int rollPrimitive) {
        this.rollPrimitive = rollPrimitive;
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
