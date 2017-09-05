package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street{
    public static final String EXAMPLE = "Woodlands St 82";
    public static final String MESSAGE_STREET_CONSTRAINTS =
            "Street can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public Street(String street, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedStreet = street.trim();
        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    public String getStreet(){
        return this.value;
    }
    /**
     * Returns true if the given string is a valid block number.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

