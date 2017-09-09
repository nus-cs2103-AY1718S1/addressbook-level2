package seedu.addressbook.data.person;

abstract public class Contact {

    public String value;

    abstract public boolean isValid(String test);
    abstract public boolean equals(Object item);
    public String toString() {
        return value;
    }
    public int hashCode() {
        return value.hashCode();
    }
}
