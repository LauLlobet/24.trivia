package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
    Players players = new Players();
    int[] board = new int[6];
    int[] score = new int[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    Player currentPlayer;

    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public boolean add(String playerName) {
		
		
	    players.add(new Player(playerName,0, players.getNumberOfPlayers()));

	    board[players.getNumberOfPlayers()] = 0;
	    score[players.getNumberOfPlayers()] = 0;
	    currentPlayer = players.getAtPosition(0);

		return true;
	}

	public void roll(int roll) {
		System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer()) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentPlayer.isInPenaltyBox()){
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer()) + " is getting out of the penalty box");
				board[currentPlayer.getNumberOfPlayer()] = board[currentPlayer.getNumberOfPlayer()] + roll;
				if (board[currentPlayer.getNumberOfPlayer()] > 11) board[currentPlayer.getNumberOfPlayer()] = board[currentPlayer.getNumberOfPlayer()] - 12;
				
				System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer())
						+ "'s new location is " 
						+ board[currentPlayer.getNumberOfPlayer()]);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer()) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			board[currentPlayer.getNumberOfPlayer()] = board[currentPlayer.getNumberOfPlayer()] + roll;
			if (board[currentPlayer.getNumberOfPlayer()] > 11) board[currentPlayer.getNumberOfPlayer()] = board[currentPlayer.getNumberOfPlayer()] - 12;
			
			System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer())
					+ "'s new location is " 
					+ board[currentPlayer.getNumberOfPlayer()]);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (board[currentPlayer.getNumberOfPlayer()] == 0) return "Pop";
		if (board[currentPlayer.getNumberOfPlayer()] == 4) return "Pop";
		if (board[currentPlayer.getNumberOfPlayer()] == 8) return "Pop";
		if (board[currentPlayer.getNumberOfPlayer()] == 1) return "Science";
		if (board[currentPlayer.getNumberOfPlayer()] == 5) return "Science";
		if (board[currentPlayer.getNumberOfPlayer()] == 9) return "Science";
		if (board[currentPlayer.getNumberOfPlayer()] == 2) return "Sports";
		if (board[currentPlayer.getNumberOfPlayer()] == 6) return "Sports";
		if (board[currentPlayer.getNumberOfPlayer()] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayer.isInPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				players.getAtPosition(currentPlayer.getNumberOfPlayer()).increaseScoreByOne();
                printCurrentPlayerStatus();

                boolean winner = didPlayerWin();
                nextPlayer();
				
				return winner;
			} else {
                nextPlayer();
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
            players.getAtPosition(currentPlayer.getNumberOfPlayer()).increaseScoreByOne();
            printCurrentPlayerStatus();

            boolean winner = didPlayerWin();
            nextPlayer();
			
			return winner;
		}
	}

    private void nextPlayer() {
        currentPlayer = players.nextPlayerAfter(currentPlayer);
    }

    private void printCurrentPlayerStatus() {
        System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer()).getStatusString());
    }

    public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.getAtPosition(currentPlayer.getNumberOfPlayer())+ " was sent to the penalty box");
		currentPlayer.setInPenaltyBox(true);

        nextPlayer();
		return true;
	}


	private boolean didPlayerWin() {
		return !(players.getAtPosition(currentPlayer.getNumberOfPlayer()).getScore() == 6);
	}
}
