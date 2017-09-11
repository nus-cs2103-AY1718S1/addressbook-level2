package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    public static final String MESSAGE_CONTACT_CONSTRAINTS = "Contact details may be in any format";
    public static final String CONTACT_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Contact(String value, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidDetail(trimmedValue)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedValue;
    }

    /**
     * Returns true if the given string is a valid person contact detail.
     */
    public static boolean isValidDetail(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
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
