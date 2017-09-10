package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A superclass for Email, Address, Phone in the addressbook.
 * Implementations should guarantee: value is present and isPrivate is provided.
 */
public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact() {

    }
    /**
     * Validates given contact string.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String value, boolean isPrivate, String contactValidationRegex,
                   String messageContactConstraints) throws IllegalValueException{
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidContact(trimmedValue, contactValidationRegex)) {
            throw new IllegalValueException(messageContactConstraints);
        }
        this.value = trimmedValue;
    }

    /**
     * Returns true if the given string is a valid person contact.
     */
    public static boolean isValidContact(String test, String validationString) {
        return test.matches(validationString);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
