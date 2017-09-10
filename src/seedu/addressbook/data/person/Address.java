package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

import java.util.Objects;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE =
            Block.EXAMPLE + ", " +
            Street.EXAMPLE + ", " +
            Unit.EXAMPLE + ", " +
            PostalCode.EXAMPLE;

    private static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person's block, street, unit and postal code should not contain commas.";

    private static final String ADDRESS_VALIDATION_REGEX = "[^,]+,[^,]+,[^,]+,[^,]+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;

        String trimmedAddress = address.trim();
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] addressParts = trimmedAddress.split(",");
        this.block = new Block(addressParts[0]);
        this.street = new Street(addressParts[1]);
        this.unit = new Unit(addressParts[2]);
        this.postalCode = new PostalCode(addressParts[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    private static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.block + ", " + this.street + ", " + this.unit + ", " + this.postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postalCode.equals(((Address) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.block, this.street, this.unit, this.postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
