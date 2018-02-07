package seedu.addressbook.data.person;

/**
 * Represents the street of a person's address.
 */
public class Street {
    private static String street;

    public Street(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String st) {
        this.street = st;
    }
}
