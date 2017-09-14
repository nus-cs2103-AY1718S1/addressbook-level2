package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public final String value;
    private boolean isPrivate;


    public Contact(String contact, boolean isPrivate, String MESSAGE_CONTACT_CONSTRAINTS, String CONTACT_VALIDATION_REGEX) throws IllegalValueException {
        String trimmedContact = contact.trim();
        this.isPrivate = isPrivate;
        if (!isValidContact(trimmedContact, CONTACT_VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    private static boolean isValidContact(String test, String CONTACT_VALIDATION_REGEX) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Contact && this.value.equals(((Contact) other).value));
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

