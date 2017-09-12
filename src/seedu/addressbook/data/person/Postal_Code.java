package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Postal_Code {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Person address can be in any format";
    public static final String POSTAL_CODE_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given postal code.
     *
     * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
     */

    public Postal_Code(String postCode, boolean isPrivate) throws IllegalValueException{
        String trimmedPostalCode = postCode.trim();
        this.isPrivate = isPrivate;
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid postal code
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Postal_Code // instanceof handles nulls
                && this.value.equals(((Postal_Code) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}