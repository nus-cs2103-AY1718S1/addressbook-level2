package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.*;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in format: BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode code;

    private String[] splitted = new String[4];
    public static final int BLOCK_INDEX = 0, STREET_INDEX = 1, UNIT_INDEX = 2, POSTALCODE_INDEX = 3;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        splitAddress(trimmedAddress,this.splitted);
        this.value = block.getBlock() + ", " + street.getStreet() + ", " +
                unit.getUnit() + ", " + code.getCode();
    }

    /**
     * Split given address and attributed each component th
     * the respective object
     *
     * @param trimmedAddress
     * @param splitted
     */
    public void splitAddress(String trimmedAddress, String[] splitted ) {
        splitted = trimmedAddress.split(",");
        this.block = new Block(splitted[BLOCK_INDEX].trim());
        this.street = new Street(splitted[STREET_INDEX].trim());
        this.unit = new Unit(splitted[UNIT_INDEX].trim());
        this.code = new PostalCode(splitted[POSTALCODE_INDEX].trim());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
