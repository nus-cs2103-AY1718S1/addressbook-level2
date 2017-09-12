package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String,String)}
 */

public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate,String MESSAGE_CONSTRAINTS,String VALIDATION_REGEX) throws IllegalValueException {

        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact,VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid person contact.
     */
    public static boolean isValidContact(String test,String VALIDATION_REGEX) {
        return test.matches(VALIDATION_REGEX);
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
