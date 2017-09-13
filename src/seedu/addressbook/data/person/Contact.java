package seedu.addressbook.data.person;

public class Contact {
    public String value;

    public Contact() {

    }
    public Contact(String object) {
        this.value = object.trim();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
