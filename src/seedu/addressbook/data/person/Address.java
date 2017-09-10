package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in this format :" +
                                                            "Block, Street Name, Unit Number, Postal Code";
    public static final String ADDRESS_VALIDATION_REGEX = "[A-Za-z0-9], \\s.+, \\s.+, \\s\\d+";

    public final String value;
    private boolean isPrivate;
    
    public final Block BLOCK = new Block("");
    public final Street STREET_NAME = new Street("");
    public final Unit UNIT_NUMBER = new Unit("");
    public final PostalCode POSTAL_CODE = new PostalCode("");

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
        
        parseAddress(trimmedAddress);
        
        this.value = trimmedAddress;
    }

    /**
     * Parse given address.
     */
    public void parseAddress(String trimmedAddress) {
        String[] parsedAddress = trimmedAddress.split(", ");
        
        BLOCK.setBlock(parsedAddress[0]);
        STREET_NAME.setStreetName(parsedAddress[1]);
        UNIT_NUMBER.setUnitNumber(parsedAddress[2]);
        POSTAL_CODE.setPostalCode(parsedAddress[3]);
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "" + BLOCK + " " + STREET_NAME + " " + UNIT_NUMBER + " " + POSTAL_CODE;
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
