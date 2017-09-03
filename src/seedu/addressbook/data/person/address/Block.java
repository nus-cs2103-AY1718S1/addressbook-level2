package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block implements AddressComponent {
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Block number should be a positive integer number.";
    // Block number has to be positive integer numeral.
    public static final String ADDRESS_VALIDATION_REGEX = "^[1-9]\\d*$";

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
    public boolean isValidAddress(String address) {
        return address.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String getValue() {
        return value;
    }
}
