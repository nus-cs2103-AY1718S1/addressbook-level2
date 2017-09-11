package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String value, boolean isPrivate, String messageConstraints, String validationRegex)
            throws IllegalValueException {
        String trimmedAddress = value.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedAddress, validationRegex)) {
            throw new IllegalValueException(messageConstraints);
        }
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid contact.
     */
    public static boolean isValidContact(String test, String validationRegex) {
        return test.matches(validationRegex);
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
