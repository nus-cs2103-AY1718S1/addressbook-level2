package seedu.addressbook.data.person;

public class Contact {
    public static boolean isValidContact(String test, String validationString) {
        return test.matches(validationString);
    }
}
