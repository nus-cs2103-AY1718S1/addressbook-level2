package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clem, #12-02, 1234";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in proper format";
    public static final String ADDRESS_VALIDATION_REGEX = "(\\d+), ([\\w\\s]+), (#[\\w\\s-]+), (\\d+)";
    public static final Pattern ADDRESS_DATA_ARGS_FORMAT = Pattern.compile(ADDRESS_VALIDATION_REGEX);

    public final String value;
    private boolean isPrivate;

    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

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

        final Matcher matcher = ADDRESS_DATA_ARGS_FORMAT.matcher(value.trim());
        if (matcher.matches()) {
            block = new Block(matcher.group(1));
            street = new Street(matcher.group(2));
            unit = new Unit(matcher.group(3));
            postalCode = new PostalCode(matcher.group(4));
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

    public boolean isPrivate() {
        return isPrivate;
    }
}