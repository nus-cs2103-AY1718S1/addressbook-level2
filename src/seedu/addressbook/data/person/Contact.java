package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact() {
    }

    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        value = contact;
    }

    public static boolean isValid(String test, String regex) {
       return test.matches(regex);
    }

    public String toString(String contact) {
        return contact;
    }

    public int hashCode(String contact) {
        return contact.hashCode();
    }
}
