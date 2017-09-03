package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.HashMap;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid if all address components are valid.
 */
public class Address {
    /**
     * For now, we assume that the user will always input all of the four components of the address.
     * We also assume that the address input must be in the order of BLOCK, STREET_NAME, UNIT, POSTAL_CODE.
     * TODO: Can we remove these two pre-assumptions?
     */
    public static final String EXAMPLE = "123, Beach Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of "
            + "BLOCK, STREET_NAME, UNIT, POSTAL_CODE, where different components are separated by commas.";

    /**
     * Stores all the different components of a full address (block number, street name, unit number and postal code)
     * in a HashMap and the format of (in the <String, AddressComponent> key-value pair.
     */
    private HashMap<String, AddressComponent> components = new HashMap<>();

    /**
     * Keys for different components in an address, used by {@link #components}.
     */
    private static final String COMPONENT_KEY_BLOCK = "block number";
    private static final String COMPONENT_KEY_STREET = "street name";
    private static final String COMPONENT_KEY_UNIT= "unit number";
    private static final String COMPONENT_KEY_POSTAL= "postal code";

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        setComponents(address);
    }

    /**
     * Separates the different components of an address and stores them into respective classes.
     *
     * @param address is the whole address (from user input) in string format.
     * @throws IllegalValueException if given address string is invalid.
     */
    private void setComponents(String address) throws IllegalValueException {
        components.put(COMPONENT_KEY_BLOCK, new Block(address));
    }

    public String getValue() {
        return components.get(COMPONENT_KEY_BLOCK).getValue();
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                    && this.getValue().equals(((Address) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
