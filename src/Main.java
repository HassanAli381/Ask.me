import Helpers.GenerateUsers;
import Helpers.Menu;
import Users.*;
import System.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenerateUsers generatedUsers = new GenerateUsers(5);
        generatedUsers.generate();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        UserController userController = new UserController();
        while(true) {
            menu.showMenu();
            int choice = sc.nextInt();
            if(choice == 1) {
                //check if there is a user currently logged in
                 boolean isLoggedIn = UserController.isLoggedIn();
                if(isLoggedIn) {
                    System.out.println("You must be logged out to be able to register!");
                    continue;
                }

                // Register a user
                System.out.println("Enter your id");
                int id = sc.nextInt();

                if (UsersRetrieval.getUser(id) != null) {
                    System.out.println("User already Exists! please try again with another id");
                    continue;
                }

                System.out.println("Enter your name");
                String name = sc.next();

                System.out.println("Enter your age");
                int age = sc.nextInt();

                System.out.println("Enter your password");
                String password = sc.next();

                User user = new User(id, age, name, password);
                UserAuth userAuth = new UserAuth(user);
                userAuth.registerUser(user);
            }
            else if(choice == 2) {
                //check if there is a user currently logged in
                 boolean isLoggedIn = UserController.isLoggedIn();
                if(isLoggedIn) {
                    System.out.println("You must be logged out to be able to login!");
                    continue;
                }
                // log user in
                System.out.println("Enter your id");
                int id = sc.nextInt();
                System.out.println("Enter password");
                String password = sc.next();
                UserAuth userAuth = new UserAuth();
                userAuth.loginUser(id, password);
            }
            else if(choice == 3) {
                // get active user
                User loggedInUser = Data.loggedInUser;
                if(loggedInUser == null) {
                    System.out.println("No user logged in");
                }
                else {
                    System.out.println("Active user is " + loggedInUser.getName());
                }
            }
            else if(choice == 4) {
                // Retrieve all users
                UsersRetrieval.getAllUsers();
            }
            else if(choice == 5) {
                // Send Question

                // check if a user is currently logged in
                boolean isLoggedIn = UserController.isLoggedIn();
                if(!isLoggedIn) {
                    System.out.println("You must be logged in to be able to send questions");
                    continue;
                }

                System.out.println("Enter receiver id");
                int id = sc.nextInt();
                userController.sendQuestion(Data.loggedInUser, id);
            }
            else if(choice == 6) {
                // Answer Question

                // check if a user is currently logged in
                boolean isLoggedIn = UserController.isLoggedIn();
                if(!isLoggedIn) {
                    System.out.println("You must be logged in to be able to answer questions");
                    continue;
                }

                userController.AnswerQuestion(Data.loggedInUser);
            }
            else if(choice == 7) {
                // show feed
                Feed.showFeed();
            }
            else if(choice == 8){
                boolean isLoggedIn = UserController.isLoggedIn();
                if(!isLoggedIn) {
                    System.out.println("You must be logged in to be able to log out");
                    continue;
                }
                System.out.println("Hope to see you soon, " + Data.loggedInUser.getName() + ":)");
                System.out.println("Logged out successfully");
                Data.loggedInUser = null;
            }
            else if(choice == 9) {
                System.out.println("Thanks for using my App, See You Soon :)");
                break;
            }
            else {
                System.out.println("Wrong Choice, please try again");
            }
        }
    }
}