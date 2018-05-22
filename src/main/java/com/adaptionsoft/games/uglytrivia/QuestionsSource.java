package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionsSource {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public  QuestionsSource(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createQuestion("Pop Question " , i));
            scienceQuestions.addLast(createQuestion("Science Question ",i));
            sportsQuestions.addLast(createQuestion("Sports Question ",i));
            rockQuestions.addLast(createQuestion("Rock Question ",i));
        }
    }

    public String createQuestion(String field, int index){
        return field + index;
    }


    public void askQuestion(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }



}
