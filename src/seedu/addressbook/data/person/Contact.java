package seedu.addressbook.data.person;

public class Contact {

    private boolean isPrivate;

    public Contact(boolean isPrivate){
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
