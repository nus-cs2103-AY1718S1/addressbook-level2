package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact information.
 */

public class Contact {

    private final String example;
    private final String message_contact_constraints;
    private final String contact_validation_regex;

    public final String value;
    private boolean isPrivate;

    /**
     * Stores and validates given contact information.
     *
     * @param contact
     * @param isPrivate
     * @param example
     * @param constraints
     * @param regex
     * @throws IllegalValueException if the given contact is invalid
     */
    protected Contact(String contact, boolean isPrivate, String example, String constraints, String regex)
            throws IllegalValueException {
        this.example = example;
        this.message_contact_constraints = constraints;
        this.contact_validation_regex = regex;

        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(message_contact_constraints);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given contact is a valid contact.
     */
    public boolean isValidContact(String test) {
        return test.matches(contact_validation_regex);
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
