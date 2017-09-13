package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.Postal_Code;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "263, Jurong East St21 , #12-835, 600263";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "INVALID FORMAT\nValid format for your address should be: Block, Street, Unit, Postal_Code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final int blockIndex = 0;
    public static final int streetIndex = 1;
    public static final int unitIndex = 2;
    public static final int postalCodeIndex = 3;


    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private Postal_Code postalcode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] address_Information = address.split(", ");
        this.isPrivate = isPrivate;

        if (address_Information.length == 4) {
            this.block = new Block(address_Information[blockIndex]);
            this.street = new Street(address_Information[streetIndex]);
            this.unit = new Unit(address_Information[unitIndex]);
            this.postalcode = new Postal_Code(address_Information[postalCodeIndex]);
            this.value = trimmedAddress;
        }
        else {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }


    @Override
    public String toString() {
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalcode.getPostalCode();
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
