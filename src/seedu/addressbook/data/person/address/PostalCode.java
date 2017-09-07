package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
    public static final String EXAMPLE = "145394";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code has to be 6 digits";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "\\b\\d{6}\\b";

    public final String value;

    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given invalid street string
     */

    public PostalCode(String postalCode) throws IllegalValueException{
        String trimmedPostalCode = postalCode.trim();
        if(!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return (other == this)
                || ((other instanceof PostalCode)
                && value.equals(((PostalCode) other).value));
    }

    @Override
    public int hashCode() {return value.hashCode(); }

}
