package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block;
    private PostalCode postalCode;
    private Street street;
    private Unit unit;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate);
        String trimmedAddress = address.trim();

        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        splitAddress(value);

    }

    /**
     * Split given address into block, unit, street and postal code.
     */
    public void splitAddress(String value) {
        String[] values = value.split(",");
        if (values.length >= 4) {
            block = new Block(values[Block.BLOCK_VALUE_NO]);
            postalCode = new PostalCode(Integer.parseInt(values[PostalCode.POSTAL_CODE_VALUE_NO].trim()));
            unit = new Unit(values[Unit.UNIT_VALUE_NO]);
            street = new Street(values[Street.STREET_VALUE_NO]);
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
}
