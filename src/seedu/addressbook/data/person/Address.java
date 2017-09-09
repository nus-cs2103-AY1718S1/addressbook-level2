package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Addresses in BLOCK, STREET, UNIT, POSTAL CODE format";
    public static final Pattern ADDRESS_VALIDATION_REGEX =
            Pattern.compile("(?<block>[^,]+)"
                + " ,\\s+(?<street>[^,]+)"
                + " ,\\s+(?<unit>[^,]+)"
                + " ,\\s+(?<postalCode>[^,]+)");

    public final String value;
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        final Matcher matcher = ADDRESS_VALIDATION_REGEX.matcher(trimmedAddress);
        if (!matcher.matches()) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        this.block = new Block(matcher.group("block"));
        this.street = new Street(matcher.group("street"));
        this.unit = new Unit(matcher.group("unit"));
        this.postalCode = new PostalCode(matcher.group("postalCode"));
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
