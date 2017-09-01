package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 *  We split the person's address class into several subclass
 *  Including Block, Street, Unit, and Postal Code
 *  For Unit, it is a string representing the person's address unit part
 *  It should follow the unit_validation_regex, which examples to "#12-34"
 */
public class Unit {
    private String unitString;
    private String value;

    private static final String UNIT_STRING_CONSTRAINTS = "Unit string is a string representing the unit";
    private static final String UNIT_VALIDATION_REGEX = "#[0-9]+-[0-9]+";

    /**
     * construct the unit object and validate the street string passed in
     * @param inputString
     * @throws IllegalValueException
     */
    public Unit ( String inputString ) throws IllegalValueException {
        unitString = inputString;
        if (!isValidStreetString(unitString)){
            throw new IllegalValueException(UNIT_STRING_CONSTRAINTS);
        }
        value = unitString;
    }

    /**
     * getter to help retrieve the String version of the unit
     * @return the unit version of the street
     */
    public String getUnitValue () {
        return value;
    }

    /**
     * validation checker for the unit string
     * @param unitString
     * @return true if the unit string is in line with the constraints by regex
     */
    public static boolean isValidStreetString ( String unitString ) {
        return (unitString.matches(UNIT_VALIDATION_REGEX));
    }

    @Override
    public String toString () {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit)other).getUnitValue())); // state check
    }
}

