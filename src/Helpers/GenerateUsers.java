package Helpers;
import System.Data;
import Users.User;

import java.util.HashSet;
import java.util.Random;

public class GenerateUsers {
    private int sz;
    private int []ids;
    private String []names = {"Ahmed", "Mohamed", "Ali", "Hassan", "Omar"};
    private int []ages;
    private String []passwords;
    public GenerateUsers(int sz) {
        this.sz = sz;
        this.ids = new int[sz];
        generateRandIntegers(ids);
        this.ages = new int[sz];
        generateRandIntegers(ages);
        this.passwords = new String[sz];
        for(int i = 0; i < sz; i++) {
            passwords[i] = "12345";
        }
    }

    public void generateRandIntegers(int [] array) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            Random rand = new Random();
            int randVal = ((rand.nextInt() % 100) + 100) % 100;
            while(set.contains(randVal)) {
                randVal = ((rand.nextInt() % 100) + 100) % 100;
            }
            set.add(randVal);
            array[i] = randVal;
        }
    }

    public void generate() {
        Data data = new Data();
        User curUser = null;
        for(int i = 0; i < this.sz; i++) {
            curUser = new User(ids[i], ages[i], names[i], passwords[i]);
            data.addUser(curUser);
        }

    }

}
