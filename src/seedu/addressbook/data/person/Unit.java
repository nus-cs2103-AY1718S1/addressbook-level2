package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the Unit part of a Person's address
 * Guarantees: immutable; is valid as declared in {@link #isValidAddressUnit(String)}
 */

public class Unit {
    public static final String MESSAGE_ADDRESS_UNIT_CONSTRAINTS = "Address unit must be in the form " +
            "#[FLOOR]-[HOUSE UNIT], where FLOOR and HOUSE UNIT are non-empty contiguous array of digits.";
    public static final String UNIT_VALIDATION_REGEX = "#\\p{Digit}+-\\p{Digit}+";

    public final String value;

    /**
     * Validates the given unit.
     * @param unit given by the user.
     * @throws IllegalValueException if unit is not valid.
     */
    public Unit(String unit) throws IllegalValueException{
        if(!isValidAddressUnit(unit)){
            throw new IllegalValueException(MESSAGE_ADDRESS_UNIT_CONSTRAINTS);
        }
        this.value = unit;
    }

    /**
     * Returns true of the unit is a valid unit number.
     * A valid unit number is in the form #[FLOOR]-[HOUSE UNIT], where FLOOR and HOUSE UNIT are
     * non-empty contiguous array of digits.
     */
    public static boolean isValidAddressUnit(String unit){
        return unit.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object other){
        return this == other
                || (other instanceof Unit
                && (this.value.equals(((Unit)other).value)));
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
