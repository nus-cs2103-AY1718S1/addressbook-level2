package seedu.addressbook.data.person;

public class Contact {
    protected String value;
    protected boolean isPrivate;


    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getValue() {
        return value;
    }
}
