package seedu.addressbook.data.person;

/*
 * Represents a contact detail of a person.  
 */
public class Contact {

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
