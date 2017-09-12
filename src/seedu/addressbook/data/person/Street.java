package seedu.addressbook.data.person;

/**
 * Represents a Person's street in the address book.
 */

public class Street {

    public final String value;

    public Street (String street) {
        this.value = street.trim();
    }

    public String getStreet() {
        return this.value;
    }
}
