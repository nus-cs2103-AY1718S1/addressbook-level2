package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Email extends Contact{

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email, boolean isPrivate) throws IllegalValueException {
        super();
        this.isPrivate = isPrivate;
        String trimmedEmail = email.trim();
        this.VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";
        this.EXAMPLE = "valid@e.mail";
        this.MESSAGE_CONSTRAINTS = "Person emails should be 2 alphanumeric/period strings separated by '@'";
        if (!isValid(trimmedEmail)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedEmail;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }
}
