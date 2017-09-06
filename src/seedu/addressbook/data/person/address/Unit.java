package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Unit of the address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "#12-345";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "No constraints";
    public static final String ADDRESS_VALIDATION_REGEX = ".";

    public final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
