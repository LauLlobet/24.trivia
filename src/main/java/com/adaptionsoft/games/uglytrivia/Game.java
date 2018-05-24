package com.adaptionsoft.games.uglytrivia;

public class Game {
    Players players = new Players();

    Board boardReal = new Board();
    Player currentPlayer;

    public Game() {

    }

    public void add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        boardReal.putPlayerAtZeroPosition(player);
        currentPlayer = players.getAtPosition(0);
    }

    public void roll(int rollPrimitive) {
        Roll roll = new Roll(rollPrimitive);
        printRollIntroduction(roll);

        currentPlayer.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);

        if(currentPlayer.hasAPenalisedTurn()){
            return;
        }

        boardReal.advancePlayerPositions(roll, currentPlayer);

    }


    private void printRollIntroduction(Roll roll) {
        currentPlayer.announceOwnTurn();
        roll.announceIt();

    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer.hasAPenalisedTurn()) {
            nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer.increaseScoreByOne();
        printCurrentPlayerStatus();

        boolean winner = didPlayerWin();
        nextPlayer();
        return winner;
    }


    private void nextPlayer() {
        currentPlayer = players.nextPlayerAfter(currentPlayer);
    }

    private void printCurrentPlayerStatus() {
        System.out.println(currentPlayer.getStatusString());
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox();
        nextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getScore() == 6);
    }
}
