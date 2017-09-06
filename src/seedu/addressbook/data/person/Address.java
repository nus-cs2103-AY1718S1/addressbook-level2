package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.List;
import java.util.Arrays;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be 4 strings separated by a ', '.";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+, ){3}.+";

    public final String value;
    public final Block BLOCK;   
    public final Street STREET;
    public final Unit UNIT;
    public final PostalCode POSTAL_CODE;
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
        List<String> splitAddress = Arrays.asList(trimmedAddress.split(","));
        this.BLOCK = new Block(splitAddress.get(0));
        this.STREET = new Street(splitAddress.get(1));
        this.UNIT = new Unit(splitAddress.get(2));
        this.POSTAL_CODE = new PostalCode(splitAddress.get(3));
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
