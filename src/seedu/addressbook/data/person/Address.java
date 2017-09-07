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

    public static final String EXAMPLE = "123, some street, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Format: Block, Street, Unit, PostalCode";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalcode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] AddressDetails = address.split(", ");
        this.isPrivate = isPrivate;

        if (AddressDetails.length==4) {
            this.block = new Block(AddressDetails[0]);
            this.street = new Street(AddressDetails[1]);
            this.unit = new Unit(AddressDetails[2]);
            this.postalcode = new PostalCode(AddressDetails[3]);
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
