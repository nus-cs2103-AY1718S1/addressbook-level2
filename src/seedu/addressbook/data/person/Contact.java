package seedu.addressbook.data.person;

public class Contact {

    private String value;
    private boolean isPrivate;

    public Contact() {

    }

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getValue() {
        return value;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }
}
