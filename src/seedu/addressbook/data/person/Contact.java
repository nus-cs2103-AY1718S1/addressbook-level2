package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {

    /**
     * Default Constructor.
     *
     * @throws IllegalValueException if some illegal value passed in
     */
    public Contact() throws IllegalValueException {}


    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract int hashCode();
}
