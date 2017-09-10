package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public String value;
    private boolean isPrivate;

    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        value = contact;
    }

    public static boolean isValid(String test, String regex) {
       return test.matches(regex);
    }

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
