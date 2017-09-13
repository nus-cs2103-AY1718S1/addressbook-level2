package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A superclass for Phone, Email, and Java. We seek to extract out the common methods.
 */

public class Contact {
    public String value;
    private boolean isPrivate;

    // Setters
    public void setValue(String value) {
        this.value = value;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
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
