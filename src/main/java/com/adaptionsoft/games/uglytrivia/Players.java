package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Players {

    private ArrayList<String> playersList = new ArrayList<String>();

    public boolean add(String o) {
        boolean ans = playersList.add(o);
        System.out.println(o.toString() + " was added");
        System.out.println("They are player number " + playersList.size());
        return ans;
    }

    public int getNumberOfPlayers() {
        return playersList.size();
    }

    public String getAtPosition(int currentPlayer) {
        return playersList.get(currentPlayer);
    }
}
