package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Common class for a person's personal details
 */
public class Contact {

    public final String value;
    protected boolean isPrivate;
    
    protected Contact(String value, boolean isPrivate, String validationRegex, String msgConstraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValid(trimmedValue, validationRegex)) {
            throw new IllegalValueException(msgConstraints);
        }
        this.value = trimmedValue;
    }

    public static boolean isValid(String test, String validationRegex) {
        return test.matches(validationRegex);
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
