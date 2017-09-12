package seedu.addressbook.data.person.contact;

/**
 * Represents a persons contact detail
 */
public class Contact {
    
    protected boolean isPrivate;
    protected String value;
    
    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getValue() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public String toString() {
        return getValue();
    }
    
    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.getValue().equals(((Contact) other).getValue())); // state check
    }
}
