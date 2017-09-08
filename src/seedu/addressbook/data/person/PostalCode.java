package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the postal code in a person's address.
 */
public class PostalCode {
    private final String value;
    private static final String POSTAL_VALIDATION_REGEX = "[0-9]+";
    private static final String MESSAGE_POSTAL_CONSTRAINTS = "Person address postalCode can only contain numbers";

    /**
     * Postal Code Constructor
     *
     * @param postalCode initial untrimmed string value
     * @throws IllegalValueException if postalCode string is invalid
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode.trim())) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }
        value = postalCode.trim();
    }

    /**
     * Validates current PostalCode object.
     *
     * @return true if this postal code is valid
     */
    public boolean isValidPostalCode() {
        return value.matches(POSTAL_VALIDATION_REGEX);
    }

    /**
     * Validates a given postalCode string.
     *
     * @param testPostalCodeString postalCode of the address
     * @return true if testPostalCodeString is valid postalCode value
     */
    public static boolean isValidPostalCode(String testPostalCodeString) {
        return testPostalCodeString.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && value.equals(((PostalCode) other).value)); // state check
    }
}
