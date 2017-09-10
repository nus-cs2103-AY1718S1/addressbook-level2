package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's unit.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "38";
    private static final String MESSAGE_UNIT_CONSTRAINTS = "Address's unit should not be empty";
    private static final String UNIT_VALIDATION_REGEX = "[^,]+";

    private final String unit;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }

        this.unit = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid unit.
     */
    private static boolean isValidUnit(String test) {
        return test.matches(Unit.UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return unit;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unit.equals(((Unit) other).unit)); // state check
    }

    @Override
    public int hashCode() {
        return unit.hashCode();
    }
}
