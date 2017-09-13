package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
    public static final String EXAMPLE = "#01-01 or #01-111";
    public static final String UNIT_VALIDATION_REGEX = "#\\d{1,3}-\\d{2,4}";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit number must contain # and have at least 1-3 digits before the hyphen and 2-4 digits after";

    public final String value;

    /**
     * Validates given Unit.
     *
     * @throws IllegalValueException if given street unit is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        if (!isValidUnit(unit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = unit;
    }

    /**
     * Returns true if a given string is a valid unit.
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
}
