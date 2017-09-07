package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-24, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person's address must be in BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    public Block block;
    public Unit unit;
    public Street street;
    public PostalCode post;
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

        String[] splitAddress = AddressSplitter(trimmedAddress);

        block = new Block(splitAddress[0]);
        street = new Street(splitAddress[1]);
        unit = new Unit(splitAddress[2]);
        post = new PostalCode(Integer.parseInt(splitAddress[3]));
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

    /**
     * fullAddress[0] : BLOCK
     * fullAddress[1] : STREET
     * fullAddress[2] : UNIT
     * fullAddress[3] : POSTALCODE
     */

    public String[] AddressSplitter(String address){
        String[] fullAddress = new String[4];
        int counter = 0;
        for(String token: address.split(", ")){
            fullAddress[counter] = token;
            counter++;
        }

        return fullAddress;

    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
