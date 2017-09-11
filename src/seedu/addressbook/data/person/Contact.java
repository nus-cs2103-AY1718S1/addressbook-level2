package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a component of a Person in the address book.
 * Guarantees: immutable
 */
public class Contact {
    public final String value;
    public boolean isPrivate;

    public Contact(String value, boolean isPrivate) throws IllegalValueException {
        this.value = value;
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
