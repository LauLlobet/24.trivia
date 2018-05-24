package com.adaptionsoft.games.uglytrivia;

import java.util.Hashtable;

public class Board {
    private Hashtable<Player, Integer> positionFor = new Hashtable<Player, Integer>();

    public void advancePlayerPositions(Roll roll,Player player){
        int newPosition = positionFor.get(player)+ roll.getRollPrimitive();
        if (newPosition > 11){
            newPosition = newPosition - 12;
        }
        positionFor.put(player, newPosition);
        System.out.println(player
                + "'s new location is "
                + positionOf(player));
    }

    public void putPlayerAtZeroPosition(Player player){
        positionFor.put(player,0);
    }

    String currentCategory(int currentPlayerBoardPosition) {
        if (currentPlayerBoardPosition == 0) return "Pop";
        if (currentPlayerBoardPosition == 4) return "Pop";
        if (currentPlayerBoardPosition == 8) return "Pop";
        if (currentPlayerBoardPosition == 1) return "Science";
        if (currentPlayerBoardPosition == 5) return "Science";
        if (currentPlayerBoardPosition == 9) return "Science";
        if (currentPlayerBoardPosition == 2) return "Sports";
        if (currentPlayerBoardPosition == 6) return "Sports";
        if (currentPlayerBoardPosition == 10) return "Sports";
        return "Rock";
    }

    public String categoryForCellWhereLies(Player player) {
        return currentCategory(positionFor.get(player));

    }

    public int positionOf(Player player) {
        return positionFor.get(player);
    }
}
