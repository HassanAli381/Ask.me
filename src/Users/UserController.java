package Users;
import Questions.QuestionsRetrieval;
import System.Data;
import Questions.Question;

import java.util.HashSet;
import java.util.Scanner;

public class UserController {
    Data data;
    Question question;
    public UserController() {}

    public void sendQuestion(User sender, int receiverID) {
        User receiver = UsersRetrieval.getUser(receiverID);
        if(receiver == null) {
            System.out.println("No Such User! please try again.");
            return ;
        }

        question = new Question();
        question = question.makeQuestion(new Scanner(System.in));
        if (question == null)
            return ;

        question.setSender(sender);
        question.setReceiver(receiver);

        receiver.receivedQuestions.add(question);
        receiver.unAnsweredQuestions.add(question.getId());

        sender.sentQuestions.add(question);
        data = new Data();
        data.addQuestion(question);
        System.out.println("Question Sent successfully!");
    }

    public void ShowUnAnsweredQuestions(HashSet<Integer> unansweredQuestions) {
        for(int id : unansweredQuestions) {
            Question question = QuestionsRetrieval.getquestion(id);
            assert question != null;
            System.out.println("id = " + question.getId());
            System.out.println("Q = " + question.getQuestion());
        }
    }

    public void AnswerQuestion(User user) {
        HashSet<Integer> unansweredQuestions = user.unAnsweredQuestions;
        if(unansweredQuestions.isEmpty()) {
            System.out.println("Your questions inbox is empty!");
            return ;
        }

        this.ShowUnAnsweredQuestions(unansweredQuestions);

        System.out.println("Enter question id");
        Scanner sc = new Scanner(System.in);
        int qId = sc.nextInt();

        if(unansweredQuestions.contains(qId)) {
            System.out.println("Enter Question Answer");
            String answer = sc.next();

            Question curQ = QuestionsRetrieval.getquestion(qId);
            if(curQ == null) {
                System.out.println("No such question");
                return ;
            }

            curQ.setAnswer(answer);
            curQ.setAnswered(true);
            unansweredQuestions.remove(qId);
            user.answeredQuestions.add(qId);
            System.out.println("Question answered successfully!");
        }
        else {
            System.out.println("There is no question with this id!");
        }
    }

    public static boolean isLoggedIn() {
        User loggedInUser = Data.loggedInUser;
        return loggedInUser != null;
    }
}
