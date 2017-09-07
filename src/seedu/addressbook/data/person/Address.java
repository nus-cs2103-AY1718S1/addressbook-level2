package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person address must incude a block, street, unit and postal code, seperated by a ','";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] addressComponents = address.split(",");

        this.isPrivate = isPrivate;

        if (addressComponents.length != 4) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.block = new Block(addressComponents[0], isPrivate);
        this.street = new Street(addressComponents[1], isPrivate);
        this.unit = new Unit(addressComponents[2], isPrivate);
        this.postalCode = new PostalCode(addressComponents[3], isPrivate);

        this.value = new String(this.block.toString() + ", " + this.street.toString() + ", " +
        this.unit.toString() + ", " + this.postalCode);
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
