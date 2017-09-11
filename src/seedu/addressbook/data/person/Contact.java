package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Pattern;

/**
 * Represents a Person's generic contact field in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContactField(String, Pattern)}
 */
public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given value using supplied validator pattern.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Contact(String value, boolean isPrivate, Pattern validatorPattern, String msgConstraint)
            throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidContactField(trimmedValue, validatorPattern)) {
            throw new IllegalValueException(msgConstraint);
        }
        this.value = value;
    }

    /**
     * Returns true if a given value string matches the supplied validator.
     * 
     * @param test the string value to be tested
     * @param validatorPattern compiled regex validator pattern to be used to matched against
     * @return true if test matches the supplied regex validator pattern
     */
    public static boolean isValidContactField(String test, Pattern validatorPattern) {
        return validatorPattern.matcher(test).matches();
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
