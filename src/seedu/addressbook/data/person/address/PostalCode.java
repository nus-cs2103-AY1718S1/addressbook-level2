package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode implements AddressComponent {
    public static final String EXAMPLE = "119627";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Postal code must be a 6-digit positive integer";
    // Postal code has to be non-sign 6-digit integer numeral.
    public static final String ADDRESS_VALIDATION_REGEX = "[1-9]\\d{5}(?!\\d)";

    private final String value;

    /**
     * Validates the given postal code.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public PostalCode(String address) throws IllegalValueException {
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
