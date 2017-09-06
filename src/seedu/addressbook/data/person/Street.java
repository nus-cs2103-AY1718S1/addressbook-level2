package seedu.addressbook.data.person;


/**
 * Represents an Address' Street in the address book.
 * Guarantees: is an string.
 */

public class Street {
    private String streetName;

    public Street(String streetName) {
        this.streetName = streetName;
    }

    public String getStreet() {
        return streetName;
    }


}
