package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public static String EXAMPLE = "";
    public static String MESSAGE_CONSTRAINTS = "";
    public static String VALIDATION_REGEX = "";
public abstract class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given information.
     *
     * @throws IllegalValueException if given information string is invalid.
     */
    public Contact(String information, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedInfo = information.trim();
        if (!isValidInfo(trimmedInfo)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedInfo;
    }

    /**
     * Returns true if the given string is a piece of valid information.
     */
    public static boolean isValidInfo(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
