package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public final String value;
    private boolean isPrivate;


    public Contact(String trimmedContact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        trimmedContact = trimmedContact.trim();
        this.value = trimmedContact;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }

}
