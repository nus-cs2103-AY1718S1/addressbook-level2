package seedu.addressbook.data.person;

/**
 * A superclass for Email, Address, Phone in the addressbook.
 * Implementations should guarantee: value is present and isPrivate is provided.
 */
public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact() {

    }

    public Contact(String value, boolean isPrivate) {
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
