package com.adaptionsoft.games.uglytrivia;

public class Game {
    private Players players = new Players();
    private Board board = new Board();
    private Player currentPlayer;

    public void add(Player player) {
        players.add(player);
        board.putPlayerAtZeroPosition(player);
        currentPlayer = players.getAtPosition(0);
    }

    public void roll(Roll roll) {
        announceRollAndTurn(roll);
        currentPlayer.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);
        if(currentPlayer.hasAPenalisedTurn()){
            return;
        }
        board.advancePlayerPositionsAndAskQuestion(roll, currentPlayer);

    }

    public boolean playTurn() {
        if (currentPlayer.hasAPenalisedTurn()) {
            return true;
        }
        currentPlayer.increaseScoreByOne();
        return currentPlayer.hasNotWon();
    }

    public boolean setCurrentPlayerInPenaltyBox() {
        currentPlayer.setInPenaltyBox();
        return true;
    }

    private void announceRollAndTurn(Roll roll) {
        currentPlayer.announceOwnTurn();
        roll.announceIt();

    }



    public void nextPlayer() {
        currentPlayer = players.nextPlayerAfter(currentPlayer);
    }


}
