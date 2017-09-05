package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    // public final String value;

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode code;

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

        String[] value = trimmedAddress.split(",");
        this.block = new Block(value[0].trim());
        this.street = new Street(value[1].trim());
        this.unit = new Unit(value[2].trim());
        this.code = new PostalCode(value[3].trim());

        // this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.value + ", " + street.value + ", " + unit.value + ", " + code.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || ((other instanceof Address) // instanceof handles nulls
                && (this.block.equals(((Address) other).block)) // state check
                && (this.street.equals(((Address) other).street)) // state check
                && (this.unit.equals(((Address) other).unit)) // state check
                && (this.code.equals(((Address) other).code))); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
