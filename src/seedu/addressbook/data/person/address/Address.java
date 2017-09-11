package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses must be in format of a/block-number, street-name, unit-number, postal-code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    public String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] addressComponents = trimmedAddress.split(",");
        if(!isValidAddress(trimmedAddress, addressComponents)){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String blockComponent = addressComponents[0];
        String streetComponent = addressComponents[1];
        String unitComponent = addressComponents[2];
        String postalCodeComponent = addressComponents[3];

        this.isPrivate = isPrivate;
        this.block = new Block(blockComponent);
        this.street = new Street(streetComponent);
        this.unit = new Unit(unitComponent);
        this.postalCode = new PostalCode(postalCodeComponent);
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test, String[] addressComponents) {
        return test.matches(ADDRESS_VALIDATION_REGEX) && addressComponents.length == 4;
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
