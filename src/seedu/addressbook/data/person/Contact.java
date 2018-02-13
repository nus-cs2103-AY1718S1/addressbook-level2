package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the contact information for a person
 */

public class Contact {
    protected Person person;
    private static String MESSAGE_CONSTRAINTS;
    private static String VALIDATION_REGEX;

    protected final String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact is invalid {@link #isValidContact(String) }.
     */
    public Contact(String constraints, String regex, String received, boolean isPrivate) throws IllegalValueException {
        MESSAGE_CONSTRAINTS = constraints;
        VALIDATION_REGEX = regex;
        this.isPrivate = isPrivate;
        String contact = received.trim();
        if (!isValidContact(contact)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = contact;
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    protected boolean isValidContact(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * @return specific contact information of a person
     */
    public String getValue() {
        return value;
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