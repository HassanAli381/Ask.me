package System;

import Questions.Question;
import Users.User;

import java.util.ArrayList;

public class Data {
    public static User loggedInUser = null;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Question> questions = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void addUser(User newUser) {
        users.add(newUser);
    }

    public static void addQuestion(Question newQuestion) {
        questions.add(newQuestion);
    }
}
