package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address must be in the format a/(BLOCK), (STREET), (UNIT), (POSTAL CODE)";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    public final Block blockComponent;
    public final Street streetComponent;
    public final Unit unitComponent;
    public final Postal postalComponent;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] addressComponents = trimmedAddress.split(",");
        if (addressComponents.length == 4) {
            this.blockComponent = new Block(addressComponents[0]);
            this.streetComponent = new Street(addressComponents[1]);
            this.unitComponent = new Unit(addressComponents[2]);
            this.postalComponent = new Postal(addressComponents[3]);
        }
        else { throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS); }

        this.isPrivate = isPrivate;
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String stringFormat = blockComponent.getBlock() + ", "
                + streetComponent.getStreet() + ", "
                + unitComponent.getUnit() + ", "
                + postalComponent.getPostal();
        return stringFormat;
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
