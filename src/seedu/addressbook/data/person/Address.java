package seedu.addressbook.data.person;

import seedu.addressbook.commands.IncorrectCommand;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_ADDRESS_FORMAT;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = Block.EXAMPLE + ", " + Street.EXAMPLE + ", " + Unit.EXAMPLE + "," + PostalCode.EXAMPLE;
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should contain block, street, unit and postal code: \n"
                                                            + Block.MESSAGE_BLOCK_CONSTRAINTS + "\n"
                                                            + Street.MESSAGE_STREET_CONSTRAINTS + "\n"
                                                            + Unit.MESSAGE_UNIT_CONSTRAINTS + "\n"
                                                            + PostalCode.MESSAGE_POSTALCODE_CONSTRAINTS;
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final Pattern ADDRESS_ARGS_FORMAT =
                            Pattern.compile("(?<block>[^,]+)"
                                        + "(?<street>[^,]+)"
                                        + "(?<unit>[^,]+)"
                                        + "(?<postalcode>[^,]+)");

    public final Block _block;
    public final Street _street;
    public final Unit _unit;
    public final PostalCode _postalcode;
    public final String value;
    private boolean isPrivate;

    /**
     * Separates into block, street, unit and postal code
     *
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        final Matcher matcher = ADDRESS_ARGS_FORMAT.matcher(address.trim());
//        try {
            _block = new Block (matcher.group("block"));
            _street = new Street (matcher.group("street"));
            _unit = new Unit (matcher.group("unit"));
            _postalcode = new PostalCode (matcher.group("postalcode"));
//        } catch (IllegalValueException ive) {
//            new IncorrectCommand(MESSAGE_INVALID_ADDRESS_FORMAT);
//        }
        this.value = _block.toString() + ", " + _street.toString() + ", " + _unit.toString() + ", " + _postalcode.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    public Block getBlock() { return _block; }
    public Street getStreet() { return _street; }
    public Unit getUnit() { return _unit; }
    public PostalCode getPostalcode() { return _postalcode; }

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
