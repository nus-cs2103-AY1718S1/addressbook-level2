package seedu.addressbook.data.person;

public class Contact {

    public Boolean isPrivate;
    public Contact(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    public boolean isPrivate() {
        return isPrivate;
    }
}
