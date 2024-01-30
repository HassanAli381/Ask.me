package Users;
import System.Data;
import java.util.ArrayList;

public class UsersRetrieval {
    public static void getAllUsers() {
        ArrayList<User> allUsers = Data.getUsers();
        System.out.println("Results = " + allUsers.size());
        if (allUsers.isEmpty()) {
            System.out.println("No Users found!");
            return ;
        }
        for (User user: allUsers) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
        }
    }

    public static User getUser(int id) {
        for(User user : Data.getUsers()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
