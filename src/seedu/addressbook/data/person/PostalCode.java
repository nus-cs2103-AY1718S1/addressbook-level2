package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's Street in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "345678";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code should only contain numbers";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "\\d+";

    private final String value;

    public PostalCode(String postalCode) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        if (!isValidBlock(trimmedPostalCode))
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        this.value = trimmedPostalCode;
    }

    private boolean isValidBlock(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof PostalCode
                && this.value.equals(((PostalCode) other).value));
    }

    /**
     * Returns the hash code of the Block
     *
     * @return hash code of the block
     */
    @Override
    public int hashCode() {
        // uses block number as hash code
        return Integer.parseInt(value);
    }
}
