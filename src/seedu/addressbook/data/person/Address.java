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
    public static final String ADDRESS_COMMA_SEPARATOR_REGEX = ", ";

    // address of Person stored with respective classes
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;
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
        initializeAddress(trimmedAddress);
    }

    /**
     * Initializes the classes that constitute an Address
     *
     * @param fullAddress String address
     */

    public void initializeAddress(String fullAddress) {
        this.block = new Block (fullAddress);
        this.street = new Street (fullAddress);
        this.unit = new Unit (fullAddress);
        this.postalCode = new PostalCode(fullAddress);
    }



    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block + ADDRESS_COMMA_SEPARATOR_REGEX + street + ADDRESS_COMMA_SEPARATOR_REGEX + unit
                + ADDRESS_COMMA_SEPARATOR_REGEX + postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || this.equalsTo(other); // state check:
    }

    /**
     * Checks if an object is equals to this object
     *
     * @param other object to be compared to
     * @return true if object are equal
     */
    public boolean equalsTo(Object other) {
        if (other instanceof Address) {
            Address toBeCompared = (Address) other;
            return this.block.equals(toBeCompared.block)
                    && this.street.equals(toBeCompared.street)
                    && this.unit.equals(toBeCompared.unit)
                    && this.unit.equals(toBeCompared.postalCode);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
