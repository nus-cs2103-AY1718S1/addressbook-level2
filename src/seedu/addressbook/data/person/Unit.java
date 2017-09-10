package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's Street in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Unit {

    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
            "Unit should be two numeric strings separated by - and start with #";
    public static final String UNIT_VALIDATION_REGEX = "#[\\d]+-[\\d]+";

    private final String value;

    public Unit(String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidBlock(trimmedUnit))
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        this.value = trimmedUnit;
    }

    private boolean isValidBlock(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Unit
                && this.value.equals(((Unit) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
