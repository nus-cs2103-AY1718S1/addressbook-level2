package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
    private boolean isPrivate;
    public boolean isPrivate() {
        return isPrivate;
    }
    //TODO add message contraints
    public static final String MESSAGE_UNIT_CONSTRAINTS = "";
    public  static final String EXAMPLE = "#02-25";
    public final String value;

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
    //todo add isValidUnit method
    public static boolean isValidUnit(String test) {
        return true;
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
