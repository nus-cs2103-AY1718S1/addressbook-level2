package seedu.addressbook.data.Password;

/**
 * Stores all data relating to passwords.
 */
public class PasswordStorage {
    private static String actualPassword = "ABC123";
    private static final String examplePassword = "example_password";

    public PasswordStorage(){

    }

    public static String getActualPassword(){
        return actualPassword;
    }
    public static String getExamplePassword(){
        return examplePassword;
    }

}
