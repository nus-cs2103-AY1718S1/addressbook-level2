package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class Contact {

    public final String contact;
    private final boolean isPrivate;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.contact = contact;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return contact;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.contact.equals(((Contact) other).contact)); // state check
    }

    @Override
    public int hashCode() {
        return contact.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
