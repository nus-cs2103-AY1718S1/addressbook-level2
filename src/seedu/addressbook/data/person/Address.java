package seedu.addressbook.data.person;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses has to be in the proper format";
    public static final String ADDRESS_VALIDATION_REGEX = "(\\d+), ([\\w\\s]+), (#[\\w\\s-]+), (\\d+)";

    public final String value;
    private boolean isPrivate;

    public Block block;
    public PostalCode postalCode;
    public Street street;
    public Unit unit;

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

        parseAddressString(address);

        this.value = trimmedAddress;
    }

    private void parseAddressString(String address) throws IllegalValueException {
        Pattern r = Pattern.compile(ADDRESS_VALIDATION_REGEX);
        Matcher m = r.matcher(address);

        if (m.find()) {
            try {
                this.block = new Block(m.group(1).toString());
                this.street = new Street(m.group(2).toString());
                this.unit = new Unit(m.group(3).toString());
                this.postalCode = new PostalCode(m.group(4).toString());

            } catch(Throwable e) {
                throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
            }
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
