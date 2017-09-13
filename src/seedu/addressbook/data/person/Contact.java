package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book
 */

public abstract class Contact {

    public String value;
    protected boolean isPrivate;

    /**
     * Validates given address.
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String MESSAGE_CONTACT_CONSTRAINTS, String CONTACT_VALIDATION_REGEX) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact, CONTACT_VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    private boolean isValidContact(String test, String CONTACT_VALIDATION_REGEX) {
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
