package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {

    public String value;
    private boolean isPrivate;

    /**
     * Default Constructor.
     *
     * @throws IllegalValueException if some illegal value passed in
     */
    public Contact(boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
    }


    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract int hashCode();

    public boolean isPrivate() {
        return isPrivate;
    }
}
