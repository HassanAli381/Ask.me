package Questions;

import Users.User;

import java.util.Scanner;

public class Question {
    private int id;
    private String question;
    private String answer;
    private User receiver;
    private User sender;
    private boolean isAnswered = false;

    public Question(int id, String question, User receiver, User sender) {
        this.id = id;
        this.question = question;
        this.receiver = receiver;
        this.sender = sender;
    }

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAnswered() {
        return isAnswered;
    }
    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public static Question makeQuestion(Scanner sc) {
        System.out.println("Enter question id");
        int id = sc.nextInt();
        // check if this id exists before
        if(QuestionsRetrieval.getquestion(id) != null) {
            System.out.println("there is a question with this id, please choose another id");
            return null;
        }

        System.out.println("Enter question without spaces");
        String question = sc.next();
        return new Question(id, question);
    }

}
