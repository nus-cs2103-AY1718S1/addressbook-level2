package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable;
 */
public class Address extends Contact {

    public Address(String email, boolean isPrivate) throws IllegalValueException {
        setContactConstants("123, some street",
                "Person addresses can be in any format", ".+");
        setContact(email, isPrivate);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}
