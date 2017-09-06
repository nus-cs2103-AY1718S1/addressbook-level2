package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address should be in the following format:" +
            " BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String fullAddress;
    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private Postalcode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        splitAddress(trimmedAddress);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        fullAddress = block.getBlockNum() + ", " + street.getStreetName() +
                ", " + unit.getUnitNum() + ", " + postalCode.getPostal();
    }
    public void splitAddress(String trimmedAddress){
        String[] addressPart = trimmedAddress.split(",");
        this.block = new Block(addressPart[0].trim());
        this.street = new Street(addressPart[1].trim());
        this.unit = new Unit(addressPart[2].trim());
        this.postalCode = new Postalcode(addressPart[3].trim());

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.fullAddress.equals(((Address) other).fullAddress)); // state check
    }

    @Override
    public int hashCode() {
        return fullAddress.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
