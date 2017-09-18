package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address implements Comparable<Address> {

    public static final String EXAMPLE = "[1][2][103][111111]";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS =
            "Match failed. Person addresses should be in the following format, including \"[]\" with nothing in between each pair of brackets: \n"
            +"[block number][street line][unit number][6 digit postal code]";

    public static final Pattern ADDRESS_VALIDATION_REGEX =
            Pattern.compile("\\[(?<block>\\d+)\\]"
                    + "\\[(?<street>.+)\\]"
                    + "\\[(?<unit>\\d+)\\]"
                    + "\\[(?<postalCode>\\d{6})\\]");

    public final String value;
    private Block _block;
    private Street _street;
    private Unit _unit;
    private PostalCode _postalCode;
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
        //this.value = trimmedAddress;
        Matcher m = ADDRESS_VALIDATION_REGEX.matcher(trimmedAddress);
        m.matches();

        //System.out.println("matched. processing address...");
        String block = "[" + m.group("block") + "]";
        String street = "[" + m.group("street") + "]";
        String unit = "[" + m.group("unit") + "]";
        String postalCode = "[" + m.group("postalCode") + "]";

        _block = new Block(block);
        _street = new Street(street);
        _unit = new Unit(unit);
        _postalCode = new PostalCode(postalCode);

        value = block + street + unit + postalCode;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        Matcher m = ADDRESS_VALIDATION_REGEX.matcher(test);
        return m.matches();
        //return Pattern.matches(ADDRESS_VALIDATION_REGEX, test);
        //return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this._block.getBlock().equals(((Address) other)._block.getBlock())
                && this._street.getStreet().equals(((Address) other)._street.getStreet())
                && this._unit.getUnit().equals(((Address) other)._unit.getUnit())
                && this._postalCode.getCode().equals(((Address) other)._postalCode.getCode())); // state check
    }

    public int compareTo(Address other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}