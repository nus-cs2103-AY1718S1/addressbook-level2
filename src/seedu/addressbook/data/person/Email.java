package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable;
 */
public class Email extends Contact {

    public Email(String email, boolean isPrivate) throws IllegalValueException {
        EXAMPLE = "valid@e.mail";
        MESSAGE_CONSTRAINTS = "Person emails should be 2 alphanumeric/period strings separated by '@'";
        VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";
        setContact(email, isPrivate);
    }
}
