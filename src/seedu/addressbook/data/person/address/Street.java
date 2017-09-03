package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street implements AddressComponent {
    public static final String EXAMPLE = "Kent Ridge Road";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Street name should be a string of any format.";

    private final String value;

    /**
     * Validates the given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Street(String address) throws IllegalValueException {
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
