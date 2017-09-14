package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's faculty in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidFaculty(String)}
 */
public class Faculty {

    public static final String EXAMPLE = "engineering";
    public static final String MESSAGE_FACULTY_CONSTRAINTS = "Person's faculty should be spaces or alphabetic characters";
    public static final String FACULTY_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given faculty
     *
     * @throws IllegalValueException if given faculty string is invalid.
     */
    public Faculty(String faculty, boolean isPrivate) throws IllegalValueException {
        String trimmedFaculty = faculty.trim();
        this.isPrivate = isPrivate;
        if (!isValidFaculty(trimmedFaculty)) {
            throw new IllegalValueException(MESSAGE_FACULTY_CONSTRAINTS);
        }
        this.value = trimmedFaculty;
    }

    /**
     * Returns true if a given string is a valid person faculty.
     */
    public static boolean isValidFaculty(String test) { return test.matches(FACULTY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Faculty // instanceof handles nulls
                && this.value.equals(((Faculty) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }






}
