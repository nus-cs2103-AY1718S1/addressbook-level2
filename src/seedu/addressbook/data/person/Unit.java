package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
    private boolean isPrivate;

    public boolean isPrivate() {
        return isPrivate;
    }

    public static final String MESSAGE_UNIT_CONSTRAINTS = "Person unit should starts with '#' and seperats by '-'";
    public static final String EXAMPLE = "#02-25";
    public final String value;
    public static final String UNIT_VALIDATION_REGEX = "#+[\\w\\.]+-[\\w\\.]+";

    //add p/123 e/12@2 b/123 s/s u/#1 pc/123456
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        this.isPrivate = isPrivate;
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person unit
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
