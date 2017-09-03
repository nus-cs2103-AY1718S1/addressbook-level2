package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block implements AddressComponent {
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Block number should be an integer number.";

    private final String value;

    /**
     * Validates the given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Block(String address) throws IllegalValueException {
        String trimmedAddress = address.trim();
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }

    @Override
    public String getValue() {
        return value;
    }
}
