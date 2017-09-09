package seedu.addressbook.data.person;

public class Contact {
    protected boolean isPrivate;

    public Contact(){
        isPrivate = true;
    }

    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

}
