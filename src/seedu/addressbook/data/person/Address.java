package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link Contact#isValidContactField(String, Pattern)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final Pattern ADDRESS_VALIDATION_REGEX = Pattern.compile(".+");

    /**
     * Constructs and validates the given address within the superclass, Contact
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate, ADDRESS_VALIDATION_REGEX, MESSAGE_ADDRESS_CONSTRAINTS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}
