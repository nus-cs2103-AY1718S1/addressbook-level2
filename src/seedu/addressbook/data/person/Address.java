package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, CLementi Ave 3, #12-34, 231543";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String MESSAGE_ADDRESS_INVALID = "The address you entered is invalid";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block block = null;
    private Street street = null;
    private Unit unit = null;
    private PostalCode postalCode = null;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();

        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            System.out.println(MESSAGE_ADDRESS_INVALID);
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.value = trimmedAddress;
        separateBlock(trimmedAddress);
    }

    /**
     * Separates the address into block, street, unit and postalcode
     * assign them correctly to the variables initialised.
     * @param address
     */
    public void separateBlock(String address){
        String[] array = address.split(",");

        this.block = new Block(array[0]);
        this.street = new Street(array[1]);
        this.unit = new Unit(array[2]);
        this.postalCode = new PostalCode(array[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        String [] array = test.split(",");

        return test.matches(ADDRESS_VALIDATION_REGEX) && (array.length==4);
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
