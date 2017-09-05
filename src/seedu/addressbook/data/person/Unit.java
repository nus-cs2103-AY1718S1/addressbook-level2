package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit{
    public static final String EXAMPLE = "#07-518";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
            "Unit must start with #, followed my 2 integers, then - then 3 integers";
    public static final String UNIT_VALIDATION_REGEX = "#+[\\d.]+-[\\d.]";


    public final String value;
    private boolean isPrivate;

    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    public String getUnit(){
        return this.value;
    }
    /**
     * Returns true if the given string is a valid unit number.
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


