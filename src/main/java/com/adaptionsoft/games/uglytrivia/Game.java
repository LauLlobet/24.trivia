package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
    Players players = new Players();
    int[] board = new int[6];
    int[] score = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayerPosition = 0;
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
		
		
	    players.add(new Player(playerName,0));

	    board[players.getNumberOfPlayers()] = 0;
	    score[players.getNumberOfPlayers()] = 0;
	    inPenaltyBox[players.getNumberOfPlayers()] = false;

		return true;
	}

	public void roll(int roll) {
		System.out.println(players.getAtPosition(currentPlayerPosition) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayerPosition]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.getAtPosition(currentPlayerPosition) + " is getting out of the penalty box");
				board[currentPlayerPosition] = board[currentPlayerPosition] + roll;
				if (board[currentPlayerPosition] > 11) board[currentPlayerPosition] = board[currentPlayerPosition] - 12;
				
				System.out.println(players.getAtPosition(currentPlayerPosition)
						+ "'s new location is " 
						+ board[currentPlayerPosition]);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(players.getAtPosition(currentPlayerPosition) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			board[currentPlayerPosition] = board[currentPlayerPosition] + roll;
			if (board[currentPlayerPosition] > 11) board[currentPlayerPosition] = board[currentPlayerPosition] - 12;
			
			System.out.println(players.getAtPosition(currentPlayerPosition)
					+ "'s new location is " 
					+ board[currentPlayerPosition]);
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
		if (board[currentPlayerPosition] == 0) return "Pop";
		if (board[currentPlayerPosition] == 4) return "Pop";
		if (board[currentPlayerPosition] == 8) return "Pop";
		if (board[currentPlayerPosition] == 1) return "Science";
		if (board[currentPlayerPosition] == 5) return "Science";
		if (board[currentPlayerPosition] == 9) return "Science";
		if (board[currentPlayerPosition] == 2) return "Sports";
		if (board[currentPlayerPosition] == 6) return "Sports";
		if (board[currentPlayerPosition] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayerPosition]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				players.getAtPosition(currentPlayerPosition).increaseScoreByOne();
                printCurrentPlayerStatus();

                boolean winner = didPlayerWin();
				currentPlayerPosition++;
				if (currentPlayerPosition == players.getNumberOfPlayers()) currentPlayerPosition = 0;
				
				return winner;
			} else {
				currentPlayerPosition++;
				if (currentPlayerPosition == players.getNumberOfPlayers()) currentPlayerPosition = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
            players.getAtPosition(currentPlayerPosition).increaseScoreByOne();
            printCurrentPlayerStatus();

            boolean winner = didPlayerWin();
			currentPlayerPosition++;
			if (currentPlayerPosition == players.getNumberOfPlayers()) currentPlayerPosition = 0;
			
			return winner;
		}
	}

    private void printCurrentPlayerStatus() {
        System.out.println(players.getAtPosition(currentPlayerPosition).getStatusString());
    }

    public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.getAtPosition(currentPlayerPosition)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayerPosition] = true;
		
		currentPlayerPosition++;
		if (currentPlayerPosition == players.getNumberOfPlayers()) currentPlayerPosition = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(players.getAtPosition(currentPlayerPosition).getScore() == 6);
	}
}
