package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Contact(String detail, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedDetail = detail.trim();
        this.value = trimmedDetail;
    }


    @Override
    public String toString() {
        return value;
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public String getDetail() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;

    }
}
