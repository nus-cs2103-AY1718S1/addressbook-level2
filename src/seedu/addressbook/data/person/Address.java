package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 345678";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses should consist of Block, Street, Unit and Postal code that are separated with comma";
    public static final String ADDRESS_VALIDATION_REGEX = "[^,]+,[^,]+,[^,]+,[^,]+";
    public static final String COMMA_SPACE = ", ";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

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
        parseAddress(trimmedAddress);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.toString() + COMMA_SPACE
                + street.toString() + COMMA_SPACE
                + unit.toString() + COMMA_SPACE
                + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postalCode.equals(((Address) other).postalCode));
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    private void parseAddress(String address) throws IllegalValueException {
        String[] splitAddress = address.split(",");
        block = new Block(splitAddress[0]);
        street = new Street(splitAddress[1]);
        unit = new Unit(splitAddress[2]);
        postalCode = new PostalCode(splitAddress[3]);
    }
}
