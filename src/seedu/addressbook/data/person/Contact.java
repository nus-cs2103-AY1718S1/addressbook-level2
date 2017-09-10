package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

    private boolean isPrivate;
    public final String value;

    public Contact(String contact, String messageContactConstraints, String regexValue, boolean isPrivate) throws IllegalValueException{
        setPrivate(isPrivate);
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact,regexValue)) {
            throw new IllegalValueException(messageContactConstraints);
        }
        this.value = trimmedContact;
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


    /**
     * Returns true if the given string is a valid value of the contact.
     */
    public static boolean isValidContact(String test, String regexValue) {
        return test.matches(regexValue);
    }


    public void setPrivate(boolean aPrivate) {
        this.isPrivate = aPrivate;
    }
}
