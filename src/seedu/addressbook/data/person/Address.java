package seedu.addressbook.data.person;

import java.util.*;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    public static final String EXAMPLE = "123, some street, #11-11, 101010";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Please enter address in this format:\n"
                                                + "Block, street, unit, postal code\n"
                                                + "Postal code may be omitted";
                                                //"Person addresses can be in any format";
    //public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+,)(.+,)(.+,)(.*)";

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
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //this.value = trimmedAddress;

        Scanner sc = new Scanner(trimmedAddress).useDelimiter("\\s*,\\s*");
        this.block = new Block(sc.next());
        this.street = new Street(sc.next());
        this.unit = new Unit(sc.next());

        String output = block.getBlock()+", "+street.getStreet()+", "+unit.getUnit()+", ";
        if (sc.hasNext()){
            this.postalCode = new PostalCode(sc.next());
            output = output + postalCode.getPostalCode();
        }
        else
            this.postalCode = null;

        //String output = block.getBlock()+", "+street.getStreet()+", "+unit.getUnit()+", "+postalCode.getPostalCode();

        this.value = output;

    }
    /*
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }
    */

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
