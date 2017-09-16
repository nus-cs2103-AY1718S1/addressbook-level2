package seedu.addressbook.data.person;

import seedu.addressbook.commands.AddCommand;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.ui.TextUi;

import java.util.StringTokenizer;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String MESSAGE_ADDRESS_INVALID = "Address entered is invalid";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";


    public final String value;
    private boolean isPrivate;
    /*private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;*/


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

    }

    /*//separate address into different classes
    private int separateAddress(String trimmedAddress) {
        StringTokenizer separator = new StringTokenizer(trimmedAddress, ", ");
        int count = 0;

        while(separator.hasMoreTokens()) {
            count++;
            switch (count) {
                case 1:
                    block = new Block(separator.nextToken());
                    break;
                case 2:
                    street = new Street(separator.nextToken());
                    break;
                case 3:
                    unit = new Unit(separator.nextToken());
                    break;
                case 4:
                    postalCode = new PostalCode(separator.nextToken());
                    break;
                default:
                    return count;
            }
        }

        return count;
    }*/

    /**
     * Returns true if a given string is a valid person address.
     */
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
