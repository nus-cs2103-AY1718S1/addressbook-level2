package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address should be in the following format:" +
            " BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "(^\\d+)[,]{1}\\s{1}.+[,]{1}\\s{1}[#]{1}[0-9]+" +
            "[-]{1}[0-9]+[,]{1}\\s{1}[0-9]+$";

    public final String value;
    public Block blockNum;
    public Street streetName;
    public Unit unitNum;
    public PostalCode postalCode;
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
        splitAddress(trimmedAddress);
        this.value = trimmedAddress;
    }

    /**
     * Splits the address into block number, street name, unit number and postal code
     *
     * @param trimmedAddress
     */
    private void splitAddress(String trimmedAddress) {
        String[] splitAddress = trimmedAddress.split(",");
        blockNum = new Block(splitAddress[0].trim());
        streetName = new Street(splitAddress[1].trim());
        unitNum = new Unit(splitAddress[2].trim());
        postalCode = new PostalCode(splitAddress[3].trim());
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
