package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public final String value;
    private boolean isPrivate;
    public static final String MESSAGE_OBJECT_CAST_ERROR = "Object should be either of object Address, Phone or Email";

    public Contact(boolean isPrivate, String value) {
        this.isPrivate = isPrivate;
        this.value = value;
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

    @Override
    public boolean equals(Object other) {
        if (other instanceof Address) {
            return other == this // short circuit if same object
                    || (other instanceof Address // instanceof handles nulls
                    && this.value.equals(((Address) other).value)); // state check
        } else if(other instanceof Phone) {
            return other == this // short circuit if same object
                    || (other instanceof Phone // instanceof handles nulls
                    && this.value.equals(((Phone) other).value)); // state check
        } else if(other instanceof Email) {
            return other == this // short circuit if same object
                    || (other instanceof Email // instanceof handles nulls
                    && this.value.equals(((Email) other).value)); // state check
        } else {
            return false; //Throw Error required
        }
    }
}
