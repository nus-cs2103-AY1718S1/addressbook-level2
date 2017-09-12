package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, 04-33, 004016";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should consist of a block, street, unit number, and postal code, each separated by commas.";

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    public String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] splitAddress = address.split(",");
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (splitAddress.length != 4) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(splitAddress[0], isPrivate);
        this.street = new Street(splitAddress[1], isPrivate);
        this.unit = new Unit(splitAddress[2], isPrivate);
        this.postalCode = new PostalCode(splitAddress[3], isPrivate);
        this.value = trimmedAddress;
    }

    @Override
    public String toString() {
        return block.toString() + street.toString() + unit.toString() + postalCode.toString();
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
