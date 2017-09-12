package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact detail in the address book.
 */
public abstract class Contact {

    public String value;
    private boolean isPrivate;
    
    public Contact(String value, boolean isPrivate, String invalidInputMessage) throws IllegalValueException {
        String trimmedValue = value.trim();
        if (!isValidInput(trimmedValue)) {
            throw new IllegalValueException(invalidInputMessage);
        }
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public abstract boolean isValidInput(String test);

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
