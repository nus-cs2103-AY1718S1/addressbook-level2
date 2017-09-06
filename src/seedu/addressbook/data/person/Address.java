package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import sun.management.counter.Units;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    public final String[] addressArray;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
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
        this.addressArray = trimmedAddress.split(",");
        this.block = new Block(Integer.valueOf(addressArray[0].trim()));
        this.street = new Street(addressArray[1].trim());
        this.unit = new Unit(addressArray[2].trim());
        this.postalCode = new PostalCode(Integer.valueOf(addressArray[3].trim()));
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

class Block {
    private int block;

    public Block(int blockNum) {
        setBlock(blockNum);
    }

    public void setBlock(int blockNum) {
        block = blockNum;
    }

    public int getBlock() {
        return block;
    }
}

class Street {
    private String street;

    public Street(String streetName) {
        setStreet(streetName);
    }

    public void setStreet(String streetName) {
        street = streetName;
    }

    public String getStreet() {
        return street;
    }
}

class Unit {
    private String unit;

    public Unit(String unit) {
        setUnit(unit);
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}

class PostalCode {
    private int postalCode;

    public PostalCode(int postalCode) {
        setPostalCode(postalCode);
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
