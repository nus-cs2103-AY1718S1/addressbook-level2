package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A superclass for Phone, Email, and Address. We seek to extract out the common methods.
 */

public class Contact {
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate, String regex, String constraint) throws IllegalValueException {
        if (!isValid(value, regex)) {
            throw new IllegalValueException(constraint);
        }
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public static boolean isValid(String value, String regex) {
        return value.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
