package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
    public final String value;
    public static final String EXAMPLE = "any street name";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street address can be in any format";
    public static final String STREET_VALIDATION_REGEX = ".+";

    /**
     * Validates given street name.
     *
     * @throws IllegalValueException if given street name string is invalid.
     */

    public Street(String streetName) throws IllegalValueException{

        if (!isValidStreet(streetName)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }

        this.value = streetName;
    }

    /**
     * Returns true if a given string is a valid street name.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }


    public String getStreetName() {
        return this.value;
    }
}
