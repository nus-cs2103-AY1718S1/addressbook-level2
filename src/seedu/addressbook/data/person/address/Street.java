package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {

    public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";

    public final String value;

    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given invalid street string
     */

    public Street(String street) throws IllegalValueException{
        String trimmedStreet = street.trim();
        if(!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return (other == this)
                || ((other instanceof Street)
                && value.equals(((Street) other).value));
    }

    @Override
    public int hashCode() {return value.hashCode(); }
}
