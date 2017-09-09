package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code should be all numbers";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "^\\d+$+";

    private final String value;
    private boolean isPrivate;

    /**
     * Validates given a postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode, Boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedPostalCode = postalCode.trim();
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if the given string is a valid postal code string.
     */
    public boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
