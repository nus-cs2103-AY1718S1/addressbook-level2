package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #01-01, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person's address must be entered in the format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final int NUM_ARGS_ADDRESS = 4;
    public static final int INDEX_BLOCK = 0;
    public static final int INDEX_STREET = 1;
    public static final int INDEX_UNIT = 2;
    public static final int INDEX_POSTAL_CODE = 3;

    public final String value;
    private boolean isPrivate;

    private Block block;
    private PostalCode postalCode;
    private Street street;
    private Unit unit;

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
        createAddress(trimmedAddress);
        this.value = trimmedAddress;
    }

    /**
     * Initialises the following attributes: block, postalCode, street, unit.
     * @param trimmedAddress is of the format "a/BLOCK, STREET, UNIT, POSTAL_CODE"
     */
    private void createAddress(String trimmedAddress) throws IllegalValueException {
        String [] splitAddressByComma = trimmedAddress.split(", ");

        if (splitAddressByComma.length != NUM_ARGS_ADDRESS) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.block = new Block(splitAddressByComma[INDEX_BLOCK]);
        this.street = new Street(splitAddressByComma[INDEX_STREET]);
        this.unit = new Unit(splitAddressByComma[INDEX_UNIT]);
        this.postalCode = new PostalCode(splitAddressByComma[INDEX_POSTAL_CODE]);
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
