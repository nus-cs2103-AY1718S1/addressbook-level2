package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.io.Console;

/**
 * Represents the street in a person's address.
 */
public class Street {
    private final String value;
    private static final String STREET_VALIDATION_REGEX = "^[a-zA-Z0-9 ']*$";
    private static final String MESSAGE_STREET_CONSTRAINTS = "Person address street must contain only alphanumeric " + 
            "characters or spaces and apostrophes, without special characters";

    /**
     * Street Constructor
     *
     * @param street initial untrimmed string value
     * @throws IllegalValueException if street string is invalid
     */
    public Street(String street) throws IllegalValueException {
        if (!isValidStreet(street.trim())) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        value = street.trim();
    }

    /**
     * Validates current Street object.
     *
     * @return true if this street is valid
     */
    public boolean isValidStreet() {
        return value.matches(STREET_VALIDATION_REGEX);
    }

    /**
     * Validates a given street string.
     *
     * @param testStreetString street of the address
     * @return true if testStreetString is valid street value
     */
    public static boolean isValidStreet(String testStreetString) {
        return testStreetString.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && value.equals(((Street) other).value)); // state check
    }
}
