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
        applyRules(roll);
        if(roll.isNotPenality()){
            currentPlayer.increaseScoreByOne();
        }
    }

    private void applyRules(Roll roll) {
        if(currentPlayer.isNotPenalizedTurnAcordingToPenalizingBoxAnd(roll)){
            board.advancePlayerAndAskQuestion(roll, currentPlayer); // TODO: pass primitive to make more explicit no llogic in roll is used
        }
        setInPenaltyBoxIfRollIsPenalty(roll);

    }

    private void setInPenaltyBoxIfRollIsPenalty(Roll roll) {
        if (roll.isPenality()) {
            currentPlayer.setInPenaltyBox();
        }
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
