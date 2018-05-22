package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Players {

    private ArrayList<Player> playersList = new ArrayList<Player>();

    public boolean add(Player o) {
        boolean ans = playersList.add(o);
        System.out.println(o.toString() + " was added");
        System.out.println("They are player number " + playersList.size());
        return ans;
    }

    public int getNumberOfPlayers() {
        return playersList.size();
    }

    public Player getAtPosition(int currentPlayer) {
        return playersList.get(currentPlayer);
    }
}
