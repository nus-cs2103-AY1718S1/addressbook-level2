package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

     public static final String EXAMPLE = "123, some street";
  //  public static final String EXAMPLE = " a/123, Clementi Ave 3, #12-34, 231534 ";
        public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
   // public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in the format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

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
//        String[] addressSplit = trimmedAddress.split(",");
//        block = new Block(addressSplit[0]);
//        street = new Street(addressSplit[1]);
//        unit = new Unit(addressSplit[2]);
//        postalCode = new PostalCode(addressSplit[3]);
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

    private class Block {
        private String value;

        Block(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private class Street {
        private String value;

        Street(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private class Unit {
        private String value;

        Unit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private class PostalCode {
        private String value;

        PostalCode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
