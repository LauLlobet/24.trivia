package com.adaptionsoft.games.uglytrivia;

public class Board {
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
}
