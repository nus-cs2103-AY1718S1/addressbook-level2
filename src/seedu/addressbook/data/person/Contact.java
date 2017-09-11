package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public static final String MESSAGE_CONSTRAINTS = "";

    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate,
                   String constraintMessage, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = value.trim();
        if (!isValid(trimmedContact, validationRegex)) {
            throw new IllegalValueException(constraintMessage);
        }
        this.value = trimmedContact;
    }

    public boolean isValid(String test, String validationRegex){ return test.matches(validationRegex); }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
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
