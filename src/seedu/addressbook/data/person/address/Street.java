package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's street.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */
public class Street {

    public static final String EXAMPLE = "Oxley Road";
    private static final String MESSAGE_STREET_CONSTRAINTS = "Address's street should not be empty";
    private static final String STREET_VALIDATION_REGEX = "[^,]+";

    private final String street;

    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street) throws IllegalValueException {
        String trimmedStreet = street.trim();
        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }

        this.street = trimmedStreet;
    }

    /**
     * Returns true if a given string is a valid street.
     */
    private static boolean isValidStreet(String test) {
        return test.matches(Street.STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return street;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.street.equals(((Street) other).street)); // state check
    }

    @Override
    public int hashCode() {
        return street.hashCode();
    }
}
