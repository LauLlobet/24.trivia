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
        if(isScoreApplingRulesTo(roll)){
            currentPlayer.increaseScoreByOne();
        }
        setInPenaltyBoxIfRollIsPenalty(roll);
    }

    private boolean isScoreApplingRulesTo(Roll roll) {
        PenaltyState penaltyState =  currentPlayer.getPenaltyState(roll);
        penaltyState.printStateFor(currentPlayer.getName());
        if(penaltyState.hasANotAPenalisedTurn()){
            board.advancePlayerAndAskQuestion(roll, currentPlayer); // TODO: pass primitive to make more explicit no llogic in roll is used
            if(roll.isNotPenality()){
                return true;
            }
        }
        return false;
    }

    private void setInPenaltyBoxIfRollIsPenalty(Roll roll) {
        if (roll.isPenality()) {
            currentPlayer.setInPenaltyBox();
        }
    }

    private void printTurn(Roll roll) {
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
