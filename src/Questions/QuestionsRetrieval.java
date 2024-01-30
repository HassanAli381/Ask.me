package Questions;

import System.Data;

import java.util.ArrayList;

public class QuestionsRetrieval {
    public static void getAllQuestions() {
        ArrayList<Question> allQuestions = Data.getQuestions();
        System.out.println("Results = " + allQuestions.size());
        if (allQuestions.isEmpty()) {
            System.out.println("No Questions found!");
            return ;
        }
        for (Question question: allQuestions) {
            System.out.println(question.getId() + " " + question.getQuestion());
        }
    }

    public static Question getquestion(int id) {
        for(Question question : Data.getQuestions()) {
            if(question.getId() == id) {
                return question;
            }
        }
        return null;
    }
}
