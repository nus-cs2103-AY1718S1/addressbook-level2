package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address implements AddressComponent {
    /**
     * For now, we assume that the user will always input all of the four components of the address.
     * TODO: Can we remove this pre-assumption?
     */
    public static final String EXAMPLE = "123, Beach Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of "
                                                               + "BLOCK, STREET_NAME, UNIT, POSTAL_CODE";

    private final String value;
    private boolean isPrivate;

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
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    @Override
    public boolean isValidAddress(String test) {
        /* TODO: Fix this validity check by individually checking block, street, etc. */
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String getValue() {
        /* TODO: Fix this getter by individually checking block, street, etc. */
        return value;
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
