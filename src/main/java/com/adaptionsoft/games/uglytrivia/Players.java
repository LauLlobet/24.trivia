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

    public Player getPlayer(int currentPlayer) {
        return playersList.get(currentPlayer);
    }

    public Player nextPlayerAfter(Player currentPlayer) {
        if(isLastPlayer(currentPlayer)){
            return playersList.get(0);
        }
        int index = playersList.indexOf(currentPlayer) + 1;
        return playersList.get(index);
    }

    private boolean isLastPlayer(Player player) {
        return playersList.indexOf(player) == ( playersList.size() -1 );
    }
}
