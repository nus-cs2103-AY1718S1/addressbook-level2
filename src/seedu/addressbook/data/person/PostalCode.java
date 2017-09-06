package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode{
    public static final String EXAMPLE = "123456";
    public static final String MESSAGE_POSTAL_CONSTRAINTS =
            "Postal Code should only consists of 6 integers";
    public static final String POSTAL_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;

    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedPostal = postalCode.trim();
        if (!isValidPostal(trimmedPostal)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINTS);
        }
        this.value = trimmedPostal;
    }

    public String getPostalCode(){
        return this.value;
    }
    /**
     * Returns true if the given string is a valid block number.
     */
    public static boolean isValidPostal(String test) {
        return test.matches(POSTAL_VALIDATION_REGEX);
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

