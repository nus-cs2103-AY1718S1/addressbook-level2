package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the Street part in a Person's address.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddressStreet(String)}
 */

public class Street {

    public static final String MESSAGE_ADDRESS_STREET_CONSTRAINTS = "Address street must contain at least one" +
            " alphanumeric character.";
    public static final String STREET_VALIDATION_REGEX = "(\\p{Alnum}+)(.*)";

    public final String value;

    /**
     * Validates the given address street.
     *
     * @param street the street given by the user.
     * @throws IllegalValueException is the street is invalid.
     */
    public Street(String street) throws IllegalValueException{
        if(!isValidAddressStreet(street)){
            throw new IllegalValueException(MESSAGE_ADDRESS_STREET_CONSTRAINTS);
        }
        this.value = street;
    }

    /**
     * Returns true if the given street is valid.
     * A street is valid if it is a non-empty array containing at least one alphanumeric character.
     * @param street
     * @return
     */
    public static boolean isValidAddressStreet(String street){
        return street.matches(STREET_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object other){
        return this == other
                || (other instanceof Street
                && this.value.equals(((Street)other).value));
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
