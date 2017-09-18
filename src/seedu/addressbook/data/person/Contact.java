package seedu.addressbook.data.person;

/*
 * Represents a contact detail of a person.  
 */
public abstract class Contact {

    public final String value;
    private boolean isPrivate;

    Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public abstract boolean equals(Object other);
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }

}
