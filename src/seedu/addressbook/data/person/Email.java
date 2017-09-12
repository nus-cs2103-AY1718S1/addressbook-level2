package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable;
 */
public class Email extends Contact {
    public static final String EXAMPLE = "valid@e.mail";
    private static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    private static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    public Email(String email, boolean isPrivate) throws IllegalValueException {
        super(email, isPrivate, MESSAGE_EMAIL_CONSTRAINTS, EMAIL_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }
}
