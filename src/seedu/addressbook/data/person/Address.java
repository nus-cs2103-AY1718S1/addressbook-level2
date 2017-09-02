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

class BlockAddress {
    private String blockAddress;
    int BLOCK_ADDRESS_INDEX = 0;

    public BlockAddress(String[] fullAddress) {
        this.blockAddress = fullAddress[BLOCK_ADDRESS_INDEX];
    }

    public void setBlockAddress(String[] fullAddress) {
        this.blockAddress = fullAddress[BLOCK_ADDRESS_INDEX];
    }

    public String getBlockAddress() {
        return this.blockAddress;
    }
}


class StreetAddress {
    private String streetAddress;
    int STREET_ADDRESS_INDEX = 1;

    public StreetAddress(String[] fullAddress) {
        this.streetAddress = fullAddress[STREET_ADDRESS_INDEX];
    }

    public void setStreetAddress(String[] fullAddress) {
        this.streetAddress = fullAddress[STREET_ADDRESS_INDEX];
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }
}

class UnitAddress {
    private String unitAddress;
    int UNIT_ADDRESS_INDEX = 2;

    public UnitAddress(String[] fullAddress) {
        this.unitAddress = fullAddress[UNIT_ADDRESS_INDEX];
    }

    public void setStreetAddress(String[] fullAddress) {
        this.unitAddress = fullAddress[UNIT_ADDRESS_INDEX];
    }

    public String getStreetAddress() {
        return this.unitAddress;
    }
}

class PostalAddress {
    private String postalAddress;
    int POSTAL_ADDRESS_INDEX = 3;

    public PostalAddress(String[] fullAddress) {
        this.postalAddress = fullAddress[POSTAL_ADDRESS_INDEX];
    }

    public void setPostalAddress(String[] fullAddress) {
        this.postalAddress = fullAddress[POSTAL_ADDRESS_INDEX];
    }

    public String getPostalAddress(String[] fullAddress) {
        return this.postalAddress;
    }
}