package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Contact type in the address book (includes Phone, Email and Address).
 * Guarantees: immutable; is valid as declared in {@link #isValid(String, String)}
 */
public class Contact {
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given contact with the type of regex supplied by subclass constructor call.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String value, boolean isPrivate,
                   String constraintMessage, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = value.trim();
        if (!isValid(trimmedContact, validationRegex)) {
            throw new IllegalValueException(constraintMessage);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if a given string matches the input validation regex.
     */
    public boolean isValid(String test, String validationRegex){ return test.matches(validationRegex); }


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
