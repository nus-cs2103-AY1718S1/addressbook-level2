package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable;
 */
public class Phone extends Contact {

    public Phone(String email, boolean isPrivate) throws IllegalValueException {
        EXAMPLE = "123456789";
        MESSAGE_CONSTRAINTS = "Person phone numbers should only contain numbers";
        VALIDATION_REGEX = "\\d+";
        setContact(email, isPrivate);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }
}
