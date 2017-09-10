package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    protected boolean isPrivate;
    public final String value;

    /**
     * Validates given contact details.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Contact(String value, boolean isPrivate
            , String validationRegex, String constraintsMessage) throws IllegalValueException{
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidValue(trimmedValue, validationRegex)) {
            throw new IllegalValueException(constraintsMessage);
        }
        this.value = trimmedValue;
    }

    /**
     * Returns true if the given string is a valid input.
     */
    public boolean isValidValue(String test, String valudationRegex) {
        return test.matches(valudationRegex);
    }

    public String toString() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public int hashCode() {
        return value.hashCode();
    }
}
