package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's race in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRace(String)}
 */
public class Race {

    public static final String EXAMPLE = "Chinese";
    public static final String MESSAGE_RACE_CONSTRAINTS = "Person race must be in alphabets and no spaces";
    public static final String RACE_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given race.
     *
     * @throws IllegalValueException if given race string is invalid.
     */
    public Race(String race, boolean isPrivate) throws IllegalValueException {
        String trimmedRace = race.trim();
        this.isPrivate = isPrivate;
        if (!isValidRace(trimmedRace)) {
            throw new IllegalValueException(MESSAGE_RACE_CONSTRAINTS);
        }
        this.value = trimmedRace;
    }

    /**
     * Returns true if a given string is a valid person race.
     */
    public static boolean isValidRace(String test) {
        return test.matches(RACE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Race // instanceof handles nulls
                && this.value.equals(((Race) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}