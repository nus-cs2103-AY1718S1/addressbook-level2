package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Street of the address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */
public class Street {

    public static final String EXAMPLE = "Ang Mo Kio Street 92";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "No constraints";
    public static final String ADDRESS_VALIDATION_REGEX = ".";

    public final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street) throws IllegalValueException {
        String trimmedStreet = street.trim();
        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidStreet(String test) {
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
