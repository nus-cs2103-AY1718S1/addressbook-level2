package seedu.addressbook.data.person;

/**
 * Represents a Person's contact privacy in the address book.
 * Guarantees: immutable
 */
public class Contact {

    private boolean isPrivate;

    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

