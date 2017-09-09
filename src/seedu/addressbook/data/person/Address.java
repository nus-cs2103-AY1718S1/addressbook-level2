package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable;
 */
public class Address extends Contact {

    public Address(String email, boolean isPrivate) throws IllegalValueException {
        EXAMPLE = "123, some street";
        MESSAGE_CONSTRAINTS = "Person addresses can be in any format";
        VALIDATION_REGEX = ".+";
        setContact(email, isPrivate);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}
