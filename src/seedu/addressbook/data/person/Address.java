package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the following format: "
                                                            + "a/BLOCK, STREET, UNIT, POSTAL_CODE";

    private Block block = new Block("");
    private Street street = new Street("");
    private Unit unit = new Unit("");
    private PostalCode postalCode = new PostalCode("");

    private boolean isPrivate;

    private class Block {
        private final String value;

        Block(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
    private class Street {
        private final String value;

        Street(String street) {
            this.value = street;
        }

        public String getValue() {
            return value;
        }

    }
    private class Unit {
        private final String value;

        Unit(String unit) {
            this.value = unit;
        }

        public String getValue() {
            return value;
        }

    }
    private class PostalCode {
        private final String value;

        PostalCode(String postalCode) {
            this.value = postalCode;
        }

        public String getValue() {
            return value;
        }

    }
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

        String[] addressAsList = trimmedAddress.split(", ");
        this.block = new Block(addressAsList[0]);
        this.street = new Street(addressAsList[1]);
        this.unit = new Unit(addressAsList[2]);
        this.postalCode = new PostalCode(addressAsList[3]);
    }

    public String getValue() {
        String addressValue = block.getValue() + ", " + street.getValue()
                + ", " + unit.getValue() + ", " + postalCode.getValue();
        return addressValue;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        Boolean hasproperFormat = test.split(", ").length == 4 && test.matches(ADDRESS_VALIDATION_REGEX);
        return hasproperFormat;
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
