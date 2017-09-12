package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
    private boolean isPrivate;
    public boolean isPrivate() {
        return isPrivate;
    }
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "Postal code should be 6 digit number";
    public  static final String EXAMPLE = "123456";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";
    public final String value;

    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        this.isPrivate = isPrivate;
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid person postalCode
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX) && test.length() == 6;
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
}
