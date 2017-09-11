package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's Address' Street in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */

public class Street {
    public static final String EXAMPLE = "Clementi Ave 2";
    public static final String MESSAGE_STREET_CONSTRAINTS =
                "Person street should only contain alphabetic characters or numbers";
    public static final String STREET_VALIDATION_REGEX = "[\\p{Alpha} ]+$";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Street(String streetName, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedStreet = streetName.trim();
        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    /**
     * Returns true if the given string is a valid street name.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(STREET_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the street name, in order.
     */
    public List<String> getWordsInStreet() {
        return Arrays.asList(value.split("\\s+"));
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
