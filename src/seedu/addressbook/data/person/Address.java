package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit number, postal code";
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address has to be in this format: a/BLOCK, STREET, " +
            "UNIT, POSTAL_CODE";
    private static final String ADDRESS_VALIDATION_REGEX = "\\d{1,5}, .+, \\d{1,6}";

    private final Block blockNumber;
    private final Street streetName;
    private final Unit unit;
    private final PostalCode postalCode;
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
        String[] splitAddress = trimmedAddress.split("\\s*, \\s*");
        blockNumber = new Block(splitAddress[0]);
        streetName = new Street(splitAddress[1]);
        unit = new Unit(splitAddress[2]);
        postalCode = new PostalCode(splitAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    private static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     * Parses the various Address sub-classes into a String form and returns it.
     */
    @Override
    public String toString() {
        return blockNumber.getBlockNumber() + ", " + streetName.getStreetName() + ", " + unit.getUnit() + ", " +
                postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(other.toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block {
    private String blockNumber;

    Block(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    String getBlockNumber() {
        return blockNumber;
    }
}

class Street {
    private String streetName;

    Street(String streetName) {
        this.streetName = streetName;
    }

    String getStreetName() {
        return streetName;
    }
}

class Unit {
    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    String getUnit() {
        return unit;
    }
}

class PostalCode {
    private String postalCode;

    PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    String getPostalCode() {
        return postalCode;
    }
}