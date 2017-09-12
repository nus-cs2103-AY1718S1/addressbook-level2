package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book, superclass to Email, Address, Phone.
 * Guarantees: immutable; is valid as declared in {@link #isValidContactInfo(String)}
 */
public abstract class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String phone, boolean isPrivate, String invalidArgMessage) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedPhone = phone.trim();
        if (!isValidContactInfo(trimmedPhone)) {
            throw new IllegalValueException(invalidArgMessage);
        }
        this.value = trimmedPhone;
    }

    public abstract boolean isValidContactInfo(String test);

    @Override
    public String toString() {
        return value;
    }

    public abstract boolean equals(Object other);

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
