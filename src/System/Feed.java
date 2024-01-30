package System;
import Questions.Question;

public class Feed {
    public static void showFeed() {
        System.out.println("Feed => ");
        int size = Data.getQuestions().size();
        for(int i = size - 1; i >= 0; i--) {
         Question question = Data.getQuestions().get(i);
            if(question.isAnswered()) {
                System.out.println("Q: " + question.getQuestion());
                System.out.println("Ans: " + question.getAnswer());
                System.out.println("Sender: " + question.getSender().getName());
                System.out.println("Receiver: " + question.getReceiver().getName());
                System.out.println("-------------------------------------------\n");
            }
        }
    }
}
