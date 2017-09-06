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
    public enum AddressProperty { BLOCK, STREET, UNIT, POSTAL_CODE }

    public final String value;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final Postal postal_code;
    private boolean isPrivate;

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
        this.value = trimmedAddress;
        this.block = new Block(extractAddressProperty(trimmedAddress, AddressProperty.BLOCK));
        this.street = new Street(extractAddressProperty(trimmedAddress, AddressProperty.STREET));
        this.unit = new Unit(extractAddressProperty(trimmedAddress, AddressProperty.UNIT));
        this.postal_code = new Postal(extractAddressProperty(trimmedAddress, AddressProperty.POSTAL_CODE));
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

    public String extractAddressProperty(String address, AddressProperty addressProperty) {
        String[] addressArr = address.split(",");
        if(addressProperty.equals(AddressProperty.BLOCK))
            return addressArr[0].trim();
        else if(addressProperty.equals(AddressProperty.STREET))
            return addressArr[1].trim();
        else if(addressProperty.equals(AddressProperty.UNIT))
            return addressArr[2].trim();
        else if(addressProperty.equals(AddressProperty.POSTAL_CODE))
            return addressArr[3].trim();
        else
            return "";
    }
}
