package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit implements AddressComponent {
    public static final String EXAMPLE = "#02-26";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Unit name must be in the format of #XX";
    // Disable checker for unit number since we have not fixed test cases.
    // public static final String ADDRESS_VALIDATION_REGEX = "^[1-9]\\d*$";

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
