package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
            "Person unit should start with a hash, the floor number, dash, and the unit number";
    public static final String UNIT_VALIDATION_REGEX = "#[0-9]+-[0-9]+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}