package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's postal code.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "123456";
    private static final String MESSAGE_POSTAL_CODE_CONSTRAINTS =
            "Address's postal code should be a number";
    private static final String POSTAL_CODE_VALIDATION_REGEX = "[0-9]+";

    private final String postalCode;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.postalCode = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    private static boolean isValidPostalCode(String test) {
        return test.matches(PostalCode.POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCode.equals(((PostalCode) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return postalCode.hashCode();
    }
}
