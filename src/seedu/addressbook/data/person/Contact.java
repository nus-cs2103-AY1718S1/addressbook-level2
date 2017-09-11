package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Superclass of Email, Phone and Address
 */
public class Contact {
    public final String value;
    protected boolean isPrivate;

    public Contact(String value, boolean isPrivate, String message, String contactValidationRegex) throws IllegalValueException {
        String trimmedContact = value.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedContact, contactValidationRegex)) {
            throw new IllegalValueException(message);
        }
        this.value = trimmedContact;
    }

    public static boolean isValidContact(String test, String regex) {
        return test.matches(regex);
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
