package com.adaptionsoft.games.uglytrivia;

public class Game {
    Players players = new Players();

    Board boardReal = new Board();
    QuestionsSource questionsSource = new QuestionsSource();

    Player currentPlayer;

    public Game() {

    }

    public void add(String playerName) {
        Player player = new Player(playerName, 0, players.getNumberOfPlayers());
        players.add(player);
        boardReal.putPlayerAtZeroPosition(player);
        currentPlayer = players.getAtPosition(0);
    }

    public void roll(int rollPrimitive) {
        Roll roll = new Roll(rollPrimitive);

        printRollIntroduction(roll);


        if (currentPlayer.isInPenaltyBox() && !roll.isEven()) {
            currentPlayer.remainInPenalityBox();
        }

        if (currentPlayer.isInPenaltyBox() && roll.isEven()) {
            currentPlayer.getOutOfPenalityBox();

        }

        if(currentPlayer.isNotGettingOutOfPenailtyBox()){
            return;
        }
        advanceCurrentPlayer(roll);
        askQuesion();
    }


    private void askQuesion() {
        System.out.println("The category is " + boardReal.categoryForCellWhereLies(currentPlayer));
        questionsSource.askQuestion(boardReal.categoryForCellWhereLies(currentPlayer));
    }

    private void advanceCurrentPlayer(Roll roll) {

        boardReal.advancePlayerPositions(roll, currentPlayer);
        System.out.println(currentPlayer
                + "'s new location is "
                + boardReal.positionOf(currentPlayer));
    }

    private void printRollIntroduction(Roll roll) {
        currentPlayer.announceOwnTurn();
        roll.announceIt();

    }

    public boolean wasCorrectlyAnswered() {


        if (currentPlayer.isNotGettingOutOfPenailtyBox()) {
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
        currentPlayer.setInPenaltyBox(true);
        nextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getScore() == 6);
    }
}
