package seedu.addressbook.data.affiliation;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Affiliation in the address book.
 * Guarantees: immutable
 */
public class Affiliation {
    public static final String MESSAGE_AFFIL_CONSTRAINTS = "Affiliation should be alphanumeric.";
    public static final String AFFIL_VALIDATION_REGEX = "^[a-zA-Z0-9\\-\\s]+$";

    public final String affilName;

    /**
     * Validates given affiliation name.
     *
     * @throws IllegalValueException if the given affiliation name string is invalid.
     */
    public Affiliation(String institution) throws IllegalValueException {
        String trimmedName = institution.trim();
        System.out.println(trimmedName);
        if (!isValidAffilName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_AFFIL_CONSTRAINTS);
        }
        this.affilName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid affiliation name.
     */
    public static boolean isValidAffilName(String test) {
        return test.matches(AFFIL_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Affiliation // instanceof handles nulls
                && this.affilName.equals(((Affiliation) other).affilName)); // state check
    }

    @Override
    public int hashCode() {
        return affilName.hashCode();
    }

    @Override
    public String toString() {
        return '[' + affilName + ']';
    }

}
