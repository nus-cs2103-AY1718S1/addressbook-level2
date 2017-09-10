package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A superclass to be inherited by Address, Email and Phone.
 * Represents the general structure of contact information.
 */
public class Contact {
    public String value;
    private boolean isPrivate;


    public Contact(String information, boolean isPrivate) throws IllegalValueException {
        String trimmedInformation = information.trim();
        this.value = trimmedInformation;
        this.isPrivate = isPrivate;

    }

    public String getValue() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Returns true if a given string is a valid piece of information
     * @param test to be validated
     * @return true if string is valid
     */
    public boolean isValid(String test, String validationRegex) {
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


}
