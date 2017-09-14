package seedu.addressbook.data.person;

/**
 * Common class for a person's personal details
 */
public class Contact {

    protected final String value;
    protected boolean isPrivate;
    
    protected Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
        value = "";
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
