package seedu.addressbook.data.person;

public class Contact {

    public String value = null;
    protected boolean isPrivate;

    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
