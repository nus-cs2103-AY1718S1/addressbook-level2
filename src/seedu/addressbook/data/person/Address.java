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

    public final Block blockNumber ;
    public final Street streetName;
    public final Unit unitNumber;
    public final PostalCode postalCode;
    public final String fullAddress;

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

        final String[] splitAddress = trimmedAddress.split(",");
        blockNumber = new Block(Integer.parseInt(splitAddress[0].trim()));
        streetName = new Street(splitAddress[1].trim());
        unitNumber = new Unit(splitAddress[2].trim());
        postalCode = new PostalCode(Integer.parseInt(splitAddress[3].trim()));

        fullAddress =  blockNumber.getBlockNum() + ", " + streetName.getStreetName() +
                ", " + unitNumber.getUnitString() + ", " + postalCode.getPostalCode();

    }

    public Block getBlock() {
        return blockNumber;
    }

    public Unit getUnit() {
        return unitNumber;
    }

    public Street getStreet() {
        return streetName;
    }

    public PostalCode getPostalCode() {
        return postalCode;
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

class Block {
    int blockNumber;

    public Block() {
        blockNumber = 0;
    }

    public Block(int number) {
        blockNumber = number;
    }

    public void setBlockNum(int number) {
        blockNumber = number;
    }

    public int getBlockNum() {
        return blockNumber;
    }
}

class Street {
    private String streetName;

    public Street() {
        streetName = null;
    }

    public Street(String name) {
        streetName = name;
    }

    public void setStreetName(String name) {
        streetName = name;
    }

    public String getStreetName() {
        return streetName;
    }
}

class Unit {
    private String unitString;

    public Unit() {
        unitString = null;
    }

    public Unit(String unit) {
        unitString = unit;
    }

    public void setUnitString(String unit) {
        unitString = unit;
    }

    public String getUnitString() {
        return unitString;
    }
}

class PostalCode {
    private int postalCode;

    public PostalCode() {
        postalCode = 0;
    }

    public PostalCode(int postal) {
        postalCode = postal;
    }

    public void setPostalCode(int postal) {
        postalCode = postal;
    }

    public int getPostalCode() {
        return postalCode;
    }
}

