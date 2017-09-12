package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    protected boolean isPrivate;
    public final String value;


    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(boolean isPrivate, String value) throws IllegalValueException {
        this.isPrivate = isPrivate;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }
}
