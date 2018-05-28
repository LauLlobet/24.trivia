package com.adaptionsoft.games.uglytrivia;

public class Game {
    private Players players = new Players();
    private Board board = new Board();
    private Player currentPlayer;

    public void add(Player player) {
        players.add(player);
        board.putAtZero(player);
        currentPlayer = players.getPlayer(0);
    }

    public void playTurn(Roll roll) {
        printTurn(roll);
        if(canScoreWhenApplingRules(roll)){
            currentPlayer.increaseScoreByOne();
        }
        currentPlayer.setInPenaltyBoxDependingOn(roll);
    }

    private boolean canScoreWhenApplingRules(Roll roll) {
        PenaltyStateFromPlayer penaltyState =  currentPlayer.getAndPrintPenaltyState(roll);
        if(penaltyState.isNotPenalisedTurn()){
            board.advancePlayer(roll, currentPlayer);
        }
        return penaltyState.canScore();
    }

    private void printTurn(Roll roll) {
        currentPlayer.printOwnTurn();
        roll.print();
    }

    public void nextPlayer() {
        currentPlayer = players.nextPlayerAfter(currentPlayer);
    }

    public boolean hasCurentPlayerNotWon() {
        return currentPlayer.hasNotWon();
    }


}
