package seedu.addressbook.data.person;

/**
 * Represents a Person's street address in the address book.
 */
public class Street {

    public String streetName;

    public Street (String streetName) {
        this.streetName = streetName;
    }

    public final void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() { return "Street: " + streetName; }
    
}