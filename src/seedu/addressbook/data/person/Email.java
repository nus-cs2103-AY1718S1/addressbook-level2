package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable;
 */
public class Email extends Contact {

    public Email(String email, boolean isPrivate) throws IllegalValueException {
        setContactConstants("valid@e.mail",
                "Person emails should be 2 alphanumeric/period strings separated by '@'",
                "[\\w\\.]+@[\\w\\.]+");
        setContact(email, isPrivate);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }
}
