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
    
    @Override
    public String toString() {
        return getValue();
    }
    
    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public String getValue() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
