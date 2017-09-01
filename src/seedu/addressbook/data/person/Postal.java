package seedu.addressbook.data.person;

import javafx.geometry.Pos;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 *  We split the person's address class into several subclass
 *  Including Block, Street, Unit, and Postal Code
 *  For Postal Code, it is a integer represented by the postal code that person's address is at
 */
public class Postal {
    private int postalCode;
    private String value;

    private static final String POSTAL_CODE_CONSTRAINTS = "Block number is an 6 digits integer (checking easy";

    /**
     * construct the postal code object and validate the postal code passed in
     * @param inputNumber
     * @throws IllegalValueException
     */
    public Postal ( int inputNumber ) throws IllegalValueException {
        postalCode = inputNumber;
        if (!isValidPostalCode(postalCode)){
            throw new IllegalValueException(POSTAL_CODE_CONSTRAINTS);
        }
        value = Integer.toString(postalCode);
    }

    /**
     * getter to help retrieve the String version of the postal code
     * @return the string version of the postal code
     */
    public String getPostalCodeValue () {
        return value;
    }

    /**
     * validation checker for the postal code
     * @param postalCode
     * @return true if the postal code is in line with the constraints of 100000 to 999999 (inclusive)
     */
    public static boolean isValidPostalCode ( int postalCode ) {
        return ((postalCode >= 100000) && (postalCode <= 999999));
    }

    @Override
    public String toString () {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Postal // instanceof handles nulls
                && this.value.equals(((Postal)other).getPostalCodeValue())); // state check
    }
}

