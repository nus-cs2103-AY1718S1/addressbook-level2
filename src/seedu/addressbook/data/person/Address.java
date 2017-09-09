package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

<<<<<<< Updated upstream
    public final String value;
    private boolean isPrivate;
=======
    //public final String value;
    //private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
>>>>>>> Stashed changes

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address.trim(), isPrivate);
        String trimmedAddress = address.trim();
<<<<<<< Updated upstream
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
=======

        int numTokens = separateAddress(trimmedAddress);

        if (!isValidAddress(trimmedAddress, numTokens)) {
            System.out.println("|| " + MESSAGE_ADDRESS_INVALID);
            System.out.println("|| " +AddCommand.MESSAGE_USAGE);
>>>>>>> Stashed changes
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

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

    /*public boolean isPrivate() {
        return isPrivate;
    }*/
}
