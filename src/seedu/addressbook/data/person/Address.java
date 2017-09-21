package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Address extends Contact{

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super();
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        this.EXAMPLE = "123, some street";
        this.MESSAGE_CONSTRAINTS = "Person addresses can be in any format";
        this.VALIDATION_REGEX = ".+";
        if (!isValid(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}
