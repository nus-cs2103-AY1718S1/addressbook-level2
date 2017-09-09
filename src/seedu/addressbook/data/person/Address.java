package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private static final int BLOCK_INDEX = 0;
    private static final int POSTAL_CODE_INDEX = 3;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;

    private Block block;
    private PostalCode postalCode;
    private Street street;
    private Unit unit;

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

        storeAddress(trimmedAddress);
    }

    private void storeAddress(String trimmedAddress) {
        String[] addressSegments = trimmedAddress.split(",");
        int numAddressSegments = addressSegments.length;

        if(hasAddressSegment(numAddressSegments, BLOCK_INDEX)) {
            block = new Block(addressSegments[BLOCK_INDEX].trim());
        }

        if(hasAddressSegment(numAddressSegments, POSTAL_CODE_INDEX)) {
            postalCode = new PostalCode(addressSegments[POSTAL_CODE_INDEX].trim());
        }

        if(hasAddressSegment(numAddressSegments, STREET_INDEX)) {
            street = new Street(addressSegments[STREET_INDEX].trim());
        }

        if(hasAddressSegment(numAddressSegments, UNIT_INDEX)) {
            unit = new Unit(addressSegments[UNIT_INDEX].trim());
        }
    }

    private boolean hasAddressSegment(int numAddressSegments, int segmentIndex) {
        return numAddressSegments > segmentIndex;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String address = "";

        final String segmentEndString = ", ";
        if(block != null) {
            address += block.toString() + segmentEndString;
        }

        if(street != null) {
            address += street.toString() + segmentEndString;
        }

        if(unit != null) {
            address += unit.toString() + segmentEndString;
        }

        if(postalCode != null) {
            address += postalCode.toString() + segmentEndString;
        }

        return address.substring(0, address.length() - 2);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && (other.toString().equals(this.toString()))); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
