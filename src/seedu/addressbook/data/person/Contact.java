package seedu.addressbook.data.person;
/**
 * Represents a Person's contact in the address book.
 *
 */
public class Contact {
    public String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public void setValue(String value){
        this.value = value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
