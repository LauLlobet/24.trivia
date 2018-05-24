package com.adaptionsoft.games.uglytrivia;

import java.util.Hashtable;

public class Board {
    private Hashtable<Player, Integer> positionFor = new Hashtable<Player, Integer>();
    private QuestionsSource questionsSource = new QuestionsSource();

    public void advancePlayerPositionsAndAskQuestion(Roll roll, Player player){
        int newPosition = positionFor.get(player)+ roll.getRollPrimitive();
        if (newPosition > 11){
            newPosition = newPosition - 12;
        }
        positionFor.put(player, newPosition);
        System.out.println(player
                + "'s new location is "
                + positionOf(player));
        System.out.println("The category is " + categoryForCellWhereLies(player));
        questionsSource.askQuestion(categoryForCellWhereLies(player));
    }

    public void putPlayerAtZeroPosition(Player player){
        positionFor.put(player,0);
    }

    String currentCategory(int playerBoardPosition) {
        if (playerBoardPosition == 0) return "Pop";
        if (playerBoardPosition == 4) return "Pop";
        if (playerBoardPosition == 8) return "Pop";
        if (playerBoardPosition == 1) return "Science";
        if (playerBoardPosition == 5) return "Science";
        if (playerBoardPosition == 9) return "Science";
        if (playerBoardPosition == 2) return "Sports";
        if (playerBoardPosition == 6) return "Sports";
        if (playerBoardPosition == 10) return "Sports";
        return "Rock";
    }

    public String categoryForCellWhereLies(Player player) {
        return currentCategory(positionFor.get(player));

    }

    public int positionOf(Player player) {
        return positionFor.get(player);
    }
}
