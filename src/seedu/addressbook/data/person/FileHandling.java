package seedu.addressbook.data.person;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {


    private static final String DEFAULT_USER_PATH = "User.txt";

    public boolean CreateFile(ArrayList<User> users) {


        try {

            FileOutputStream f = new FileOutputStream("User.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(users);

            // Write objects to file

            o.close();
            f.close();


        } catch (IOException e) {

            return false;

        }

        return true;
    }

    public ArrayList<User> readFile() {

        ArrayList<User> users;

        try {
            FileInputStream fi = new FileInputStream("User.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            users = (ArrayList<User>) oi.readObject();

            oi.close();
            fi.close();


        }catch (FileNotFoundException e){
            /* Generate users */
            User user1 = new User("linus", "123456");
            User user2 = new User("john", "123456");

            users = new ArrayList<User>();
            users.add(user1);
            users.add(user2);

            FileHandling file = new FileHandling();

            file.CreateFile(users);

            return users;
        }
        catch (IOException e){
            // return null arraylist of users
            users = new ArrayList<User>();
        }catch (ClassNotFoundException e){
            users = new ArrayList<User>();
        }
        return users;
    }

}