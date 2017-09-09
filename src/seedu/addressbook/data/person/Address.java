package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String blockString, String streetString, String unitString, String postalCodeString)}
 */
public class Address {

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private boolean isPrivate;

    public static String EXAMPLE = "123, Clement Ave 3, #21-34, 213456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Personal Address should be in a format of Block, Street, Unit, Postal Code";


    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(Block block, Street street, Unit unit, PostalCode postalCode, boolean isPrivate) throws IllegalValueException {

        if (!isValidAddress(block.toString(), street.toString(), unit.toString(), postalCode.toString())) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.block = block;
        this.street = street;
        this.unit = unit;
        this.postalCode = postalCode;
        this.isPrivate = isPrivate;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public boolean isValidAddress(String blockString, String streetString, String unitString, String postalCodeString) throws IllegalValueException {
        Block testBlock = new Block (blockString, false);
        Street testStreet = new Street (streetString, false);
        Unit testUnit = new Unit (unitString, false);
        PostalCode testPostalCode = new PostalCode(postalCodeString, false);

        if (testBlock.isValidBlock(blockString) && testStreet.isValidStreet(streetString)
                && testUnit.isValidUnit(unitString) && testPostalCode.isValidPostalCode(postalCodeString)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return block.toString() + ", " + street.toString() + ", " + unit.toString() + ", " + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
