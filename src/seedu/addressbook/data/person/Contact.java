package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Contact(String contact, boolean isContactPrivate, String validationRegex, String contactConstraints) throws IllegalValueException {
        this.isPrivate = isContactPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact, validationRegex)) {
            throw new IllegalValueException(contactConstraints);
        }
        this.value = contact.trim();
    }

    /**
     * Returns true if the given string is a valid person contact.
     */
    public static boolean isValidContact(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
