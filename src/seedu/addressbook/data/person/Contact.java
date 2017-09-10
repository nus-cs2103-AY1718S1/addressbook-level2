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
}
