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

    public final String value;
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

public class Block{

    public final String value;
    private boolean isPrivate;

    public Block(String block, boolean isPrivate) {
        String trimmedBlock = block.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedBlock;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}

public class Street{

    public final String value;
    private boolean isPrivate;

    public Street(String street, boolean isPrivate) {
        String trimmedStreet = street.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedStreet;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() { return value.hashCode(); }


    public boolean isPrivate() { return isPrivate; }
}

public class Unit{

    public final String value;
    private boolean isPrivate;

    public Unit(String unit, boolean isPrivate) {
        String trimmedUnit = unit.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedUnit;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() { return value.hashCode(); }


    public boolean isPrivate() { return isPrivate; }
}

public class Postal_Code{

    public final String value;
    private boolean isPrivate;

    public Postal_Code(String postCode, boolean isPrivate) {
        String trimmedPostCode = postCode.trim();
        this.isPrivate = isPrivate;
        this.value = trimmedPostCode;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Postal_Code // instanceof handles nulls
                && this.value.equals(((Postal_Code) other).value)); // state check
    }

    @Override
    public int hashCode() { return value.hashCode(); }


    public boolean isPrivate() { return isPrivate; }
}