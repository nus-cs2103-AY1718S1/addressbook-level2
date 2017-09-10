package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #1-23, 670225";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Person addresses should have block no., street, unit and postal code separated by ', '";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d*,\\s.+\\s#\\d+-\\d+,\\s\\d{6}";

    public final String value;
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
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;

        String[] splitAddress = trimmedAddress.split(",");
        this.block = new Address.Block(splitAddress[0].trim());
        this.street = new Address.Street(splitAddress[1].trim());
        this.unit = new Address.Unit(splitAddress[2].trim());
        this.postalCode = new Address.PostalCode(splitAddress[3].trim());
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

    /**
     * Represents a Peron's block in the address book.
     */
    private class Block {

        private final String storedBlockNo;

        public Block(String blockNo) {
            this.storedBlockNo = blockNo;
        }

    }

    /**
     * Represents a Person's street in the address book.
     */
    private class Street {

        private final String storedStreet;

        public Street(String street) {
            this.storedStreet = street;
        }

    }

    /**
     * Represents a Person's unit in the address book.
     */
    private class Unit {

        private final String storedUnitNo;

        public Unit(String unitNo) {
            this.storedUnitNo = unitNo;
        }

    }

    /**
     * Represents a Person's postal code in the address book.
     */
    private class PostalCode {

        private final String storedPostalCode;

        public PostalCode(String postalCode) {
            this.storedPostalCode = postalCode;
        }

    }
}
