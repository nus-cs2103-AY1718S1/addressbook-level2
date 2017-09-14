package seedu.addressbook.data.person;

public class Contact {
    public String value;
    protected boolean isPrivate;

    public Contact() {
        this.value = "";
    }

    @Override
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

    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }
}
