package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
    public static final String EXAMPLE = "004016";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "Postal code should only contain numbers.";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";

    private final String value;
    private boolean isPrivate;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        this.isPrivate = isPrivate;

        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }

        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

    public String toString(){
        return this.value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
