package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
    public static final String EXAMPLE = "Styx Avenue 4";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Streets can be in any format.";
    public static final String STREET_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given street string is invalid.
     */
    public Street(String street, boolean isPrivate) throws IllegalValueException {
        String trimmedStreet = street.trim();
        this.isPrivate = isPrivate;

        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }

        this.value = trimmedStreet;
    }

    /**
     * Returns true if a given string is a valid street.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
