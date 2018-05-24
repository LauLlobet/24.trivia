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
        announceRollAndTurn(roll);
        currentPlayer.penaliseTurnIfItsOnPenaltyBoxDependingOn(roll);
        if(currentPlayer.hasAPenalisedTurn()){
            return;
        }
        boardReal.advancePlayerPositions(roll, currentPlayer);

    }

    public boolean wasIncorrectlyAnswered() {
        if (currentPlayer.hasAPenalisedTurn()) {
            return true;
        }
        currentPlayer.increaseScoreByOne();
        return currentPlayer.hasNotWon();
    }

    public boolean wrongAnswer() {
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
