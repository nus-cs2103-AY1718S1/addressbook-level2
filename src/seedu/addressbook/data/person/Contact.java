package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    /*
    Contact type can be Email, Address or Phone
    Guarantees: immutable; is valid as declared in {@link #validContact(String, String)}
     */
    public final String value;
    private boolean isPrivate;

    /*
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String value, boolean isPrivate,
                   String constraintMessage, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = value.trim();
        if(!validContact(trimmedContact, validationRegex)) {
            throw new IllegalValueException(constraintMessage);
        }
        this.value = value;
    }
    /*
     * Returns true if the String matches the validation regex
     */
    public boolean validContact(String str, String validationRegex) { return str.matches(validationRegex); }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
