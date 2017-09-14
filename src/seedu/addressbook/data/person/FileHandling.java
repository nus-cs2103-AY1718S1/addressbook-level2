package seedu.addressbook.data.person;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {


    private static final String DEFAULT_USER_PATH = "User.txt";

    public boolean CreateFile(ArrayList<User> users) {


        try {
            /* Open user storage file */
            FileOutputStream f = new FileOutputStream(DEFAULT_USER_PATH);
            ObjectOutputStream o = new ObjectOutputStream(f);

            /* Write objects into file */
            o.writeObject(users);

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
            FileInputStream fi = new FileInputStream(DEFAULT_USER_PATH);
            ObjectInputStream oi = new ObjectInputStream(fi);

            users = (ArrayList<User>) oi.readObject();

            oi.close();
            fi.close();


        }catch (FileNotFoundException e){
            /* Generate default users */
            User user1 = new User("linus", "123456");
            User user2 = new User("john", "123456");

            users = new ArrayList<User>();
            users.add(user1);
            users.add(user2);

            FileHandling file = new FileHandling();

            file.CreateFile(users);

            return users;
        }
        catch (Exception e){

            // return null ArrayList of users
            users = new ArrayList<User>();
        }

        return users;
    }

}