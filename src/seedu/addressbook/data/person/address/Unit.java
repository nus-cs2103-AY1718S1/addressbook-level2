package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {

    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit Number should be in #digit - digit format.";
    public static final String UNIT_VALIDATION_REGEX = "#\\d+-\\d+";
    public final String value;

    /**
     * Validates given unit Number.
     *
     * @throws IllegalValueException if given unit number string is invalid.
     */

    public Unit(String unitNumber) throws IllegalValueException{

        if (!isValidUnit(unitNumber)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }

        this.value = unitNumber;
    }

    /**
     * Returns true if a given string is a valid unit number.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
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
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }


    public String getUnitNumber() {
        return this.value;
    }

}
