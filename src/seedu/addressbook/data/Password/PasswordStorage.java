package seedu.addressbook.data.Password;

/**
 * Created by Jason An on 10/9/2017.
 */
public class PasswordStorage {
    private static String password = "ABC123";
    private static final String examplePassword = "example_password";

    public PasswordStorage(){

    }

    public static String getPassword(){
        return password;
    }
    public static String getExamplePassword(){
        return examplePassword;
    }

}
