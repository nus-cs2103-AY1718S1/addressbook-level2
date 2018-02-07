package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

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
    private void createAddress(String trimmedAddress) {
        String [] splitAddressBySlash = trimmedAddress.split("/");
        String [] splitAddressByComma = splitAddressBySlash[1].split(", ");

        this.block = new Block(splitAddressByComma[0]);
        this.street = new Street(splitAddressByComma[1]);
        this.unit = new Unit(splitAddressByComma[2]);
        this.postalCode = new PostalCode(splitAddressByComma[3]);
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
