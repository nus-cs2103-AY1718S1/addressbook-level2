package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the Postal Code part of a Person's address.
 * Guarantee: immutable; is valid as declared in {@link #isValidAddressPostal(String)}
 */

public class Postal {
    public static final String MESSAGE_ADDRESS_POSTAL_CONSTRAINTS = "Address postal code must be a non-empty" +
            " contiguous array of digits.";
    public static final String POSTAL_VALIDATION_REGEX = "\\p{Digit}+";

    public final String value;

    /**
     * Validates the given postal code.
     * @param postalCode given by the user.
     * @throws IllegalValueException if the postal code is invalid.
     */
    public Postal(String postalCode) throws IllegalValueException {
        if(!isValidAddressPostal(postalCode)){
            throw new IllegalValueException(MESSAGE_ADDRESS_POSTAL_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Returns true if the postal code given by the user is valid.
     * A postal code is valid if it is a non-empty contiguous array of digits.
     */
    private boolean isValidAddressPostal(String postalCode){
        return postalCode.matches(POSTAL_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object other){
        return this == other
                || (other instanceof Postal
                && this.value.equals(((Postal)other).value));
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
