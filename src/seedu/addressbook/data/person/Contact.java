package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

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


}
