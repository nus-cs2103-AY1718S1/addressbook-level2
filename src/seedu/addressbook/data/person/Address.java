package seedu.addressbook.data.person;

import java.util.Scanner;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #11-11, 101010";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Please enter address in this format:\n"
                                                + "BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_INVALID = "|| Format of address entered is invalid";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+,)(.+,)(.+,)(.*)";

    private Block block = null;
    private Street street = null;
    private Unit unit = null;
    private PostalCode postalCode = null;
    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate)   throws IllegalValueException{
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            System.out.println(ADDRESS_INVALID);
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;

        /**
        * Split and save parts of address to respective classes: Block, Street, Unit, PostalCode
        */
        Scanner sc = new Scanner(trimmedAddress).useDelimiter("\\s*,\\s*");
        this.block = new Block(sc.next());
        this.street = new Street(sc.next());
        this.unit = new Unit(sc.next());

        if (sc.hasNext()){
            this.postalCode = new PostalCode(sc.next());
        }

    }

    public static boolean isValidAddress(String test) {

        return (test.matches(ADDRESS_VALIDATION_REGEX));
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
