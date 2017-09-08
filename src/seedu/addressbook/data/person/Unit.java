package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit should contain numbers with a '-' in the middle and  a '#' at the front";
    public static final String UNIT_VALIDATION_REGEX = "";

    private final String value;

    public Unit (String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if(!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        value = trimmedUnit;
    }

    private static boolean isValidUnit (String test) { return test.matches(UNIT_VALIDATION_REGEX); }

    @Override
    public String toString () { return value; }
}
