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
        printRollAndCurrentPlayer(roll);
        applyFirstDiceRules(roll);
        secondRoll(roll);
    }

    private void applyFirstDiceRules(Roll roll) {
        currentPlayer.penaliseTurnIfItsOnPenaltyBoxAcordingTo(roll);
        if(currentPlayer.hasAPenalisedTurn()){
            return;
        }
        board.advancePlayerAndAskQuestion(roll, currentPlayer); // TODO: pass primitive to make more explicit no llogic in roll is used
    }

    public void secondRoll(Roll roll) {
        if (roll.isPenalityRoll()) {
            currentPlayer.setInPenaltyBox();
            return;
        }
        currentPlayer.increaseScoreByOne();
    }

    private void printRollAndCurrentPlayer(Roll roll) {
        currentPlayer.announceOwnTurn();
        roll.announceIt();

    }

    public void nextPlayer() {
        currentPlayer = players.nextPlayerAfter(currentPlayer);
    }

    public boolean hasCurentPlayerNotWon() {
        return currentPlayer.hasNotWon();
    }


}
