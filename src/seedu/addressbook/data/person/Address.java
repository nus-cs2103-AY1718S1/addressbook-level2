package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String MESSAGE_INVALID_ADDRESS = "Incorrect number of address fields";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] addressFields = trimmedAddress.split(", ");

        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        } else if (!isSufficientFields(addressFields)) {
            throw new IllegalValueException(MESSAGE_INVALID_ADDRESS);
        }
        this.value = trimmedAddress;
        storeAddressFields(addressFields);
    }

    /**
     * Stores address fields.
     */
    private void storeAddressFields(String[] addressFields) {
        block = new Block(addressFields[0]);
        street = new Street(addressFields[1]);
        unit = new Unit(addressFields[2]);
        postalCode = new PostalCode(addressFields[3]);
    }

    /**
     * Returns true if the given address has the correct number of fields.
     */
    private boolean isSufficientFields(String[] addressFields) {
        int fieldCount = addressFields.length;
        return (fieldCount == 4);
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
                && this.value.equals(((Address) other).value) // state check
                && this.block.equals(((Address) other).block) // state check
                && this.street.equals(((Address) other).street) // state check
                && this.unit.equals(((Address) other).unit) // state check
                && this.postalCode.equals(((Address) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
