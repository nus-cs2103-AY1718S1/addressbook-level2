package seedu.addressbook.data.person;

import com.sun.org.apache.xpath.internal.operations.Bool;
import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {

    private String value;
    private Boolean isPrivate;
    /**
     * Validates given information.
     *
     * @throws IllegalValueException if given information string is invalid.
     */
    public Contact(String value, Boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
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
