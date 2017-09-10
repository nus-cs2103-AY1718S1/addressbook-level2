package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's Street in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */
public class Street {

    public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_STREET_CONSTRAINTS = "Street can be in any form";
    public static final String STREET_VALIDATION_REGEX = ".+";

    private final String value;

    public Street(String street) throws IllegalValueException {
        String trimmedStreet = street.trim();
        if (!isValidStreet(trimmedStreet))
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        this.value = trimmedStreet;
    }

    private boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Street
                && this.value.equals(((Street) other).value));
    }
}
