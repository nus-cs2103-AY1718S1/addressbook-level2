package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's date of birth in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDOB(String)}
 */
public class DOB {

    public static final String EXAMPLE = "01.01.1995";
    public static final String MESSAGE_DOB_CONSTRAINTS =
            "Person date of birth should be in the format DD.MM.YYYY and all numeric digits";
    public static final String DOB_VALIDATION_REGEX = "\\d+.\\d+.\\d+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given date of birth.
     *
     * @throws IllegalValueException if given date of birth string is invalid.
     */
    public DOB(String dob, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedDOB = dob.trim();
        if (!isValidDOB(trimmedDOB)) {
            throw new IllegalValueException(MESSAGE_DOB_CONSTRAINTS);
        }
        this.value = trimmedDOB;
    }

    /**
     * Returns true if the given string is a valid person date of birth.
     */
    public static boolean isValidDOB(String test) {
        return test.matches(DOB_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DOB // instanceof handles nulls
                && this.value.equals(((DOB) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
