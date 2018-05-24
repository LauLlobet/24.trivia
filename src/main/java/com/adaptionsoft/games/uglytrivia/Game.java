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

    public void roll(Roll roll, boolean secondRoll) {
        announceRollAndCurrentPlayer(roll);
        firstDiceRules(roll);
        secondRoll(secondRoll);
    }

    private void firstDiceRules(Roll roll) {
        currentPlayer.penaliseTurnIfItsOnPenaltyBoxAcordingTo(roll);
        if(currentPlayer.hasAPenalisedTurn()){
            return;
        }
        board.advancePlayerAndAskQuestion(roll, currentPlayer);
    }

    public void secondRoll(boolean secondroll) {
        if (secondroll) {
            setCurrentPlayerInPenaltyBox();
        } else {
            playTurn();
        }
    }

    public void playTurn() {
        if (!currentPlayer.hasAPenalisedTurn()) {
            currentPlayer.increaseScoreByOne();
        }
    }

    public void setCurrentPlayerInPenaltyBox() {
        currentPlayer.setInPenaltyBox();
    }

    private void announceRollAndCurrentPlayer(Roll roll) {
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
