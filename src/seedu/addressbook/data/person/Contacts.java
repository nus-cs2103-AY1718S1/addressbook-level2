package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contacts {

    public final String value;
    private boolean isPrivate;

    public Contacts(String valueField, boolean isPrivate) {
        this.value = valueField.trim();
        this.isPrivate = isPrivate;
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
