package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
    private boolean isPrivate;
    public boolean isPrivate() {
        return isPrivate;
    }
    //TODO add message contraints
    public static final String MESSAGE_STREET_CONSTRAINTS = "";
    public  static final String EXAMPLE = "Clementi Ave 2";
    public final String value;

    public Street(String street, boolean isPrivate) throws IllegalValueException {
        String trimmedStreet = street.trim();
        this.isPrivate = isPrivate;
        if (!isValidStreet(trimmedStreet)) {
            throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
        }
        this.value = trimmedStreet;
    }

    /**
     * Returns true if a given string is a valid person street
     */
    //todo add isValidStreet method
    public static boolean isValidStreet(String test) {
        return true;
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
}
