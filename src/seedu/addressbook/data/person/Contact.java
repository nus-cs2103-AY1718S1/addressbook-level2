package seedu.addressbook.data.person;

/**
 * This is the parent class for Phone, Email and Address, so as to extract
 * as much commonality and reduce method duplication
 */

public abstract class Contact {
    private String value;
    protected boolean isPrivate;

    @Override
    public String toString(){
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Contact
                && this.getClass().equals(other.getClass())
                && this.getValue().equals(((Contact) other).getValue()));
    }

    @Override
    public int hashCode(){
        return getValue().hashCode();
    }

    public boolean isPrivate(){
        return isPrivate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
