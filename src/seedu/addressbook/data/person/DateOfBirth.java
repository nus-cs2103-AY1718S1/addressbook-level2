package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's date of birth in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class DateOfBirth {

    public static final String EXAMPLE = "07.08.1995";
    public static final String MESSAGE_DATE_CONSTRAINTS =
            "Person emails should be 2 numbers, 2 numbers and 4 numbers strings separated by '.'";
    public static final String DATE_VALIDATION_REGEX = "[0-9]*2.[0-9]*2.[0-9]+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given date of birth.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public DateOfBirth(String date, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedDate = date.trim();
        if (!isValidEmail(trimmedDate)) {
            throw new IllegalValueException(MESSAGE_DATE_CONSTRAINTS);
        }
        this.value = trimmedDate;
    }

    /**
     * Returns true if the given string is a valid person date of birth.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(DATE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateOfBirth // instanceof handles nulls
                && this.value.equals(((DateOfBirth) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
