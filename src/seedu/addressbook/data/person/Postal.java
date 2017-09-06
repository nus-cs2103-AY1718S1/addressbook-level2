package seedu.addressbook.data.person;

/**
 * Represents a Person's block in the address book.
 */

public class Postal {

    public final String value;

    public Postal (String postal) {
        this.value = postal.trim();
    }

    public String getPostal() {
        return this.value;
    }
}
