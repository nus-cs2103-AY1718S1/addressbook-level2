package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit implements AddressComponent {
    public static final String EXAMPLE = "#02-26";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Unit name should be a string with a prefix of #";
    // Unit number should start with # and we are not strict about things after the prefix.
    public static final String ADDRESS_VALIDATION_REGEX = "#.+";

    private final String value;

    /**
     * Validates the given unit number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String address) throws IllegalValueException {
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
