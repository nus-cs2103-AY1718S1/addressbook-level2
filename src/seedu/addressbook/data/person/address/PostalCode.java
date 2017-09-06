package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Postal Code of the address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Must be a 6-digits number";
    public static final String ADDRESS_VALIDATION_REGEX = "^[0-9]{1,6}$";

    public final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postalCode string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
