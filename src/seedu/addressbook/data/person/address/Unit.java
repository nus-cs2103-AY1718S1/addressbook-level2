package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {

    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit specified must begin with a # symbol";
    public static final String UNIT_VALIDATION_REGEX = "#.+";

    public final String value;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given invalid unit string
     */

    public Unit(String unit) throws IllegalValueException{
        String trimmedUnit = unit.trim();
        if(!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return (other == this)
                || ((other instanceof Unit)
                && value.equals(((Unit) other).value));
    }

    @Override
    public int hashCode() {return value.hashCode(); }

}