package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;





public abstract class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate, String MESSAGE_CONSTRAINTS) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidValue(trimmedValue)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = value;
    }

    public boolean isPrivate() { return isPrivate; }

    public abstract boolean isValidValue(String test);

    public abstract boolean equals(Object other);

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
