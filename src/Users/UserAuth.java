package Users;

import System.Data;

import java.util.Objects;

public class UserAuth extends User{

    public UserAuth() {
        super();
    }

    public UserAuth(User user) {
        super(user);
    }

    public void registerUser(User user) {
        if(UsersRetrieval.getUser(user.getId()) != null) {
            System.out.println("User Already Exists");
            return;
        }
        Data data = new Data();
        data.addUser(user);
        System.out.println("User registered successfully, you can login now!");
    }

    public void loginUser(int id, String password) {
        User user = UsersRetrieval.getUser(id);
        if(user == null || user.getId() != id || !Objects.equals(user.getPassword(), password)) {
            System.out.println("Password or id is not correct please try again");
        }
        else {
            System.out.println("Logged in successfully");
            System.out.println("Welcome, " + user.getName());
            Data.loggedInUser = user;
        }

    }
}
