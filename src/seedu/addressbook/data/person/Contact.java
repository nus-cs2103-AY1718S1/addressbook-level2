package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String, String)}
 */
public class Contact {

    public String value;
    protected boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact value string is invalid.
     */
    protected Contact(boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
    }

    /**
     * Returns true if the given string is a valid contact.
     */
    public static boolean isValid(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
