package seedu.addressbook.data.person;

/**
 * Superclass of Email, Phone and Address
 */
public class Contact {
    public static final String EXAMPLE = "Phone Email Address";
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }


}
