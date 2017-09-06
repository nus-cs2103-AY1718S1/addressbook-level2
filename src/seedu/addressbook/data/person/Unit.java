package seedu.addressbook.data.person;

/**
 * Represents a Person's address in the address book.
 */
public class Unit {

    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
