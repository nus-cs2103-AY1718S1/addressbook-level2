package seedu.addressbook.data.person;

/**
 * Represents a class whose attributes and methods
 * are shared by Phone, Address and Email class
 */

public class Contact {

    public String value;
    protected boolean isPrivate;

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)) // state check
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)) // state check
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

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
