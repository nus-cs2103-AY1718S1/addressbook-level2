package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be entered with the following format\n"
            + "a/BLOCK, STREET, UNIT, POSTAL_CODE\n"
            + "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d+, [\\w|\\s|\\d]+, #\\d+-\\d+, \\d{6}";

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private boolean isPrivate;

    private enum AddressType {
        BLOCK(0), STREET(1), UNIT(2), POSTALCODE(3);
        private int value;

        AddressType(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

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
        this.value = splitAddress(trimmedAddress);
    }

    public String splitAddress(String trimmedAddress)
    {
        String[] splitAddress = trimmedAddress.split(", ");
        block = new Block(splitAddress[AddressType.BLOCK.getValue()]);
        street = new Street(splitAddress[AddressType.STREET.getValue()]);
        unit = new Unit(splitAddress[AddressType.UNIT.getValue()]);
        postalCode = new PostalCode(splitAddress[AddressType.POSTALCODE.getValue()]);

        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getpostalCode();
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
