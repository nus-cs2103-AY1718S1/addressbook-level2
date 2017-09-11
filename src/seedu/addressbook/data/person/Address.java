package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the following format: " +
            "BLOCK, STREET, UNIT, POSTAL_CODE";
    // matches [any number], [any alphanumeric with space], #[any number]-[any number], [any 6 digit number]
    public static final String ADDRESS_VALIDATION_REGEX = "\\d+, [\\w\\d\\s]+, #\\d+-\\d+, \\d{6}$";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;

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

        String[] splitAddress = trimmedAddress.split(", ");
        block = new Block(splitAddress[Block.ADDRESS_INDEX]);
        street = new Street(splitAddress[Street.ADDRESS_INDEX]);
        unit = new Unit(splitAddress[Unit.ADDRESS_INDEX]);
        postalCode = new PostalCode(splitAddress[PostalCode.ADDRESS_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", block, street, unit, postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    private class Block {
        public static final int ADDRESS_INDEX = 0;

        private final String block;
        private Block(String b) {
            block = b;
        }
        private String get() {
            return block;
        }

        @Override
        public String toString() {
            return block;
        }
    }

    private class Street {
        public static final int ADDRESS_INDEX = 1;

        private final String street;
        private Street(String s) {
            street = s;
        }
        private String get() {
            return street;
        }

        @Override
        public String toString() {
            return street;
        }
    }

    private class Unit {
        public static final int ADDRESS_INDEX = 2;

        private final String unit;
        private Unit(String u) {
            unit = u;
        }
        private String get() {
            return unit;
        }

        @Override
        public String toString() {
            return unit;
        }
    }

    private class PostalCode {
        public static final int ADDRESS_INDEX = 3;

        private final String postalCode;
        private PostalCode(String p) {
            postalCode = p;
        }
        private String get() {
            return postalCode;
        }

        @Override
        public String toString() {
            return postalCode;
        }
    }
}
