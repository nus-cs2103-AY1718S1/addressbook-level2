package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the unit in a person's address.
 */
public class Unit {
    private final String value;
    private static final String UNIT_VALIDATION_REGEX = "#[\\d]+-[a-zA-Z0-9]+";
    private static final String MESSAGE_UNIT_CONSTRAINTS = "Person address unit must be in #[n]-[alphanumeric] format. "
                                                        + "n - number";

    /**
     * Unit Constructor
     *
     * @param unit initial untrimmed string value
     * @throws IllegalValueException if unit string is invalid
     */
    public Unit(String unit) throws IllegalValueException {
        if (!isValidUnit(unit.trim())) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        value = unit.trim();
    }

    /**
     * Validates current Unit object.
     *
     * @return true if this unit is valid
     */
    public boolean isValidUnit() {
        return value.matches(UNIT_VALIDATION_REGEX);
    }

    /**
     * Validates a given unit string.
     *
     * @param testUnitString unit of the address
     * @return true if testUnitString is valid unit value
     */
    public static boolean isValidUnit(String testUnitString) {
        return testUnitString.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && value.equals(((Unit) other).value)); // state check
    }
}
