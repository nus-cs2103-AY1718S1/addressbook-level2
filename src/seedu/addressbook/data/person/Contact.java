package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Abstracts the common patterns of contact information for a specific person.
 *
 * @author Niu Yunpeng
 */
public class Contact {
    public static final String MESSAGE_CONSTRAINTS = "Contact information can be in any format.";
    public static final String VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) throws IllegalValueException {
        String trimmedValue = value.trim();
        this.isPrivate = isPrivate;
        if (!isValid(trimmedValue)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
        this.value = trimmedValue;
    }

    private boolean isValid(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
