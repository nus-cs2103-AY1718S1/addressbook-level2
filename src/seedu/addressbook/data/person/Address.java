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

    private final int BLOCK_INDEX = 0;
    private final int STREET_INDEX = 1;
    private final int UNIT_INDEX = 2;
    private final int POSTALCODE_INDEX = 3;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

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

        String[] splitAddress = address.split(",");
        int numComponents = splitAddress.length;

        if (numComponents > BLOCK_INDEX) {
            this.block = new Block(splitAddress[BLOCK_INDEX]);
        }
        if (numComponents > STREET_INDEX) {
            this.street = new Street(splitAddress[STREET_INDEX]);
        }
        if (numComponents > UNIT_INDEX) {
            this.unit = new Unit(splitAddress[UNIT_INDEX]);
        }
        if (numComponents > POSTALCODE_INDEX) {
            this.postalCode = new PostalCode(splitAddress[POSTALCODE_INDEX]);
        }


    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {

        String combinedAddress = "";

        if (block != null) {
            combinedAddress += block.getValue();
        }
        if (street != null) {
            combinedAddress += "," + street.getValue();
        }
        if (unit != null) {
            combinedAddress += "," + unit.getValue();
        }
        if (postalCode != null) {
            combinedAddress += "," + postalCode.getValue();
        }
        return combinedAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
