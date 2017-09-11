package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate,
                   String constraintsMessage, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact, validationRegex)) {
            throw new IllegalValueException(constraintsMessage);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid person contact.
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
