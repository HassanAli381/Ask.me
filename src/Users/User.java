package Users;

import Questions.Question;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
    private int id;
    private int age;
    private String name;
    private String password;
    HashSet<Integer> answeredQuestions;
    HashSet<Integer> unAnsweredQuestions;
    ArrayList<Question> sentQuestions;
    ArrayList<Question> receivedQuestions;

    public User() {}

    public User(int id, int age, String name, String password) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.answeredQuestions = new HashSet<>();
        this.unAnsweredQuestions = new HashSet<>();
        this.sentQuestions = new ArrayList<>();
        this.receivedQuestions = new ArrayList<>();
    }

    public User(User user) {
        this.id = user.id;
        this.age = user.age;
        this.name = user.name;
        this.password = user.password;
        this.answeredQuestions = new HashSet<>();
        this.unAnsweredQuestions = new HashSet<>();
        this.sentQuestions = new ArrayList<>();
        this.receivedQuestions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
}
