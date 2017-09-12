package seedu.addressbook.data.person;

/**
 * This is a parent class of Address, Email and Phone
 */

public class Contact {

    public final String value;
    private boolean isPrivate;

    /**
     * Constructor
     */
    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.value = contact;
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
