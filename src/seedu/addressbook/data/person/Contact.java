package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public abstract class Contact {

    public static String MESSAGE_CONTACT_CONSTRAINTS;
    public static String CONTACT_VALIDATION_REGEX;

    public String value;
    private boolean isPrivate;

    /**
     * Creates contact object with given constraint message and validation regex,
     * then validates and sets a given contact.
     *
     * @throws IllegalValueException if given contact address string is invalid.
     */
    protected Contact(String constraintMessage, String validationRegex,
                      String contact, boolean isPrivate) throws IllegalValueException {
        MESSAGE_CONTACT_CONSTRAINTS = constraintMessage;
        CONTACT_VALIDATION_REGEX = validationRegex;

        setContact(contact, isPrivate);
    }

    /**
     * Validates and sets a given contact.
     *
     * @throws IllegalValueException if given contact address string is invalid.
     */
    private void setContact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid person contact.
     */
    protected static boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
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
